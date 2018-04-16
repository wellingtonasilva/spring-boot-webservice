package br.com.wsilva.fpf.produtos.controller.impl;

import br.com.wsilva.fpf.produtos.controller.ICategoriaController;
import br.com.wsilva.fpf.produtos.entity.CategoriaEntity;
import br.com.wsilva.fpf.produtos.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController implements ICategoriaController
{
    private ICategoriaService categoriaService;

    @Autowired
    public CategoriaController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public CategoriaEntity obterPorId(@PathVariable(value="id") BigInteger id)
    {
        return categoriaService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<CategoriaEntity> listar()
    {
        Iterator<CategoriaEntity> it = categoriaService.findAll().iterator();
        if (it!= null) {
            List<CategoriaEntity> list = new ArrayList<>();
            while (it.hasNext()) list.add(it.next());
            return list;
        }

        return new ArrayList<>(0);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public CategoriaEntity inserir(@RequestBody CategoriaEntity entity)
    {
        return categoriaService.save(entity);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public boolean atualizar(@RequestBody CategoriaEntity entity)
    {
        try {
            categoriaService.save(entity);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean excluir(@PathVariable(value="id")BigInteger id)
    {
        try {
            categoriaService.deleteById(id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
