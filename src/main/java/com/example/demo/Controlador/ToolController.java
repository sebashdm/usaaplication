package com.example.demo.Controlador;

import org.springframework.web.bind.annotation.*;
import com.example.demo.Modelo.Tool;
import com.example.demo.Servicio.ToolService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/Tool")
@CrossOrigin(origins = "*")

public class ToolController {
    @Autowired
    private ToolService toolService;

    @GetMapping("/all")
    public List<Tool> getAll(){
        return toolService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Tool> getTool(@PathVariable("id") int id){
        return toolService.getTool(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool save (@RequestBody Tool tool){
        return toolService.save(tool);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool update(@RequestBody Tool tool) {
        return toolService.update(tool);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int toolId){
        return toolService.deleteTool(toolId);
    }
}
