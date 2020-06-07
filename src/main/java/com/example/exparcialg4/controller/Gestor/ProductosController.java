package com.example.exparcialg4.controller.Gestor;

import com.example.exparcialg4.entity.Productos;
import com.example.exparcialg4.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    ProductosRepository productosRepository;

    @GetMapping(value={"","/"})
    public String listarProductos(Model model){
        model.addAttribute("listaProductos",productosRepository.findAll());
        return "Usuario/productosLista";
    }

    @GetMapping(value="/nuevo")
    public String nuevoProducto(){
        return "Gestor/nuevoProducto";
    }

    @PostMapping(value = "/guardar")
    public String guardarProducto(@ModelAttribute("productos")  @Valid Productos productos, BindingResult bindingResult , Model model, RedirectAttributes attr) {

        if (bindingResult.hasErrors()) {
            return "redirect:/Usuario/nuevoProducto";
        } else {
            attr.addFlashAttribute("msg", "Producto " + (productos.getIdproductos() == 0 ? "creado" : "actualizado") + " exitosamente");
            productosRepository.save(productos);
            return "redirect:/Usuario/productosLista";
        }
    }

    @GetMapping(value = "/editar")
    public String editarProducto(@ModelAttribute("shipper") Productos productos, Model model,@RequestParam("id") int id){
        Optional<Productos> optProductos = productosRepository.findById(id);
        if(optProductos.isPresent()){
            productos = optProductos.get();
            model.addAttribute("productos", optProductos.get());
            return "redirect:/Usuario/nuevoProducto";
        }else{
            return "redirect:/Usuario/productosLista";
        }
    }

    @GetMapping(value ="eliminar")
    public String eliminarProducto(Model model,
                                   @RequestParam("id") int id,
                                   RedirectAttributes attr){
        Optional<Productos> opt = productosRepository.findById(id);
        if(opt.isPresent()) {
            productosRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Producto borrado exitosamente");
        }
        return "redirect:/Usuario/productosLista";
    }

}
