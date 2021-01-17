package com.utm.resource;

import com.utm.dto.ReserveDTO;
import com.utm.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ReserveResource {
    @Autowired
    private ReserveService reserveService;

    @GetMapping("/reserves/{id}")
    public ReserveDTO getReserveById(final @PathVariable Long id){
        return reserveService.getReserveById(id);
    }

    @GetMapping("/reserves")
    public List<ReserveDTO> getAllReserves(){
        return reserveService.getAllReserves();
    }

    @PostMapping("/reserves")
    public ReserveDTO createReserve(final @Valid @RequestBody ReserveDTO reserveDTO){
        return reserveService.createReserve(reserveDTO);
    }

    @PutMapping("/reserves")
    public ReserveDTO getReserveById(final @RequestBody ReserveDTO reserveDTO){
        return reserveService.updateReserve(reserveDTO);
    }

    @DeleteMapping("/reserves/{id}")
    public void deleteReserveById(final @PathVariable Long id){
        reserveService.deleteReserveById(id);
    }
}
