package com.codegym.cms.controller;


import com.codegym.cms.model.Material;
import com.codegym.cms.model.Supplier;
import com.codegym.cms.service.MaterialService;
import com.codegym.cms.service.SupplierService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @Autowired
    SupplierService supplierService;
    //Gắn danh sách suppliers vào tất cả các model của view

    @ModelAttribute("suppliers")
    public Iterable<Supplier> suppliers() {
        return supplierService.findAll();
    }

//    //Tìm kiếm  theo biến s
//    @GetMapping("/materials")
//    public ModelAndView listMaterials(@RequestParam("s") Optional<String> s, Pageable pageable) {
//        //@PageableDefault(size = 5 ,sort = "price")
//        Page<Material> materials;
//        if (s.isPresent()) {
//            materials = materialService.findAllByNameContaining(s.get(), pageable);
//        } else {
//            materials = materialService.findAll(pageable);
//        }
//
//        ModelAndView modelAndView = new ModelAndView("/material/list");
//        modelAndView.addObject("materials", materials);
//        return modelAndView;
//    }
    //Viết lại hàm list phân trang
    @GetMapping("/materials")
    public ModelAndView listMaterials(Pageable pageable){
        Page<Material> materials = materialService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/material/list");
        modelAndView.addObject("materials",materials);
        return modelAndView;
    }

    //Hàm list bình thường
//    @GetMapping("/materials")
//    public ModelAndView listMaterial(){
//        Iterable<Material> materials = materialService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/material/list");
//        modelAndView.addObject("materials", materials);
//        return modelAndView;
//    }
    @GetMapping("/create-material")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/material/create");
        modelAndView.addObject("material", new Material());
        return modelAndView;
    }

    @PostMapping("/create-material")
    public ModelAndView saveMaterial(@ModelAttribute("material") Material material) {
        materialService.save(material);

        ModelAndView modelAndView = new ModelAndView("/material/create");
        modelAndView.addObject("material", new Material());
        modelAndView.addObject("message", "New material created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-material/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Material material = materialService.findById(id);
        if (material != null) {
            ModelAndView modelAndView = new ModelAndView("/material/edit");
            modelAndView.addObject("material", material);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-material")
    public ModelAndView updateMaterial(@ModelAttribute("material") Material material) {
        materialService.save(material);
        ModelAndView modelAndView = new ModelAndView("/material/edit");
        modelAndView.addObject("material", material);
        modelAndView.addObject("message", "Material updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-material/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Material material = materialService.findById(id);
        if (material != null) {
            ModelAndView modelAndView = new ModelAndView("/material/delete");
            modelAndView.addObject("material", material);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-material")
    public String deleteMaterial(@ModelAttribute("material") Material material) {
        materialService.remove(material.getId());
        return "redirect:materials";
    }
}
