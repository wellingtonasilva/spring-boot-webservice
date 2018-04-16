package br.com.wsilva.fpf.produtos.controller.impl;

import br.com.wsilva.fpf.produtos.controller.IOrigemController;
import br.com.wsilva.fpf.produtos.entity.OrigemEntity;
import br.com.wsilva.fpf.produtos.service.IOrigemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/origem")
public class OrigemController implements IOrigemController
{
    private IOrigemService service;

    @Autowired
    public OrigemController(IOrigemService service) {
        this.service = service;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public OrigemEntity obterPorId(@PathVariable(value="id") BigInteger id)
    {
        return service.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<OrigemEntity> listar()
    {
        Iterator<OrigemEntity> it = service.findAll().iterator();
        if (it!= null) {
            List<OrigemEntity> list = new ArrayList<>();
            while (it.hasNext()) list.add(it.next());
            return list;
        }

        return new ArrayList<>(0);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public OrigemEntity inserir(@RequestBody OrigemEntity entity)
    {
        return service.save(entity);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public boolean atualizar(@RequestBody OrigemEntity entity)
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
