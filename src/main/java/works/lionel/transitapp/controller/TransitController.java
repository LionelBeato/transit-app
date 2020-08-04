package works.lionel.transitapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import works.lionel.transitapp.model.Bus;
import works.lionel.transitapp.model.BusRequest;
import works.lionel.transitapp.service.TransitService;

@Controller
public class TransitController {
    @Autowired
    private TransitService apiService;
	
    @GetMapping("/buses")
    public String getBusesPage(Model model){
        BusRequest busRequest = new BusRequest();
        model.addAttribute("request", busRequest);
        return "index";
    }
	
    @PostMapping("/buses")
    public String getNearbyBuses(BusRequest request, Model model) {
        List<Bus> buses = apiService.getNearbyBuses(request);
        model.addAttribute("buses", buses);
        model.addAttribute("request", request);    
        return "index";
    }
}