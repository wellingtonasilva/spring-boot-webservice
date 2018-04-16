package br.com.wsilva.fpf.produtos.controller.impl;

import br.com.wsilva.fpf.produtos.controller.IProdutoController;
import br.com.wsilva.fpf.produtos.entity.ProdutoEntity;
import br.com.wsilva.fpf.produtos.service.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProdutoController implements IProdutoController
{
    private IProdutoService service;

    @Autowired
    public ProdutoController(IProdutoService service) {
        this.service = service;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ProdutoEntity obterPorId(@PathVariable(value="id") BigInteger id)
    {
        return service.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ProdutoEntity> listar()
    {
        Iterator<ProdutoEntity> it = service.findAll().iterator();
        if (it!= null) {
            List<ProdutoEntity> list = new ArrayList<>();
            while (it.hasNext()) list.add(it.next());
            return list;
        }

        return new ArrayList<>(0);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ProdutoEntity inserir(@RequestBody ProdutoEntity entity)
    {
        return service.save(entity);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public boolean atualizar(@RequestBody ProdutoEntity entity)
    {
        try {
            service.save(entity);
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
            service.deleteById(id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
