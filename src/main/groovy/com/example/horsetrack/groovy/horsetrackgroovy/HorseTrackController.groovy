package com.example.horsetrack.groovy.horsetrackgroovy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HorseTrackController {
    private HorseTrackHandler horseTrackHandler = new HorseTrackHandler();

    @GetMapping("/start")
    @ResponseBody
    String start(){
        return HorseTrackViewHelper.displayInitialInventory() + "<br/>" +
                HorseTrackViewHelper.displayInitialHorseInfo();
    }

    @GetMapping("/play/{param1}/{param2}")
    @ResponseBody
    String play(@PathVariable("param1") String param1, @PathVariable("param2") String param2) {
        return horseTrackHandler.handle(param1, param2);
    }
}
