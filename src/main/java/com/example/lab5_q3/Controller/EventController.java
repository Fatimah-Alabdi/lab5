package com.example.lab5_q3.Controller;

import com.example.lab5_q3.Api.ApiRespons;
import com.example.lab5_q3.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    ArrayList<Event> events = new ArrayList<>();
     @GetMapping("/get")
    public ArrayList<Event> getEvents() {
        return events;
    }
    @PostMapping("/add")
    public ApiRespons addEvent(@RequestBody Event event) {
         events.add(event);
         return new ApiRespons("event added successfully");
    }
    @DeleteMapping("/delete/{index}")
    public ApiRespons deleteEvent(@PathVariable int index) {
         events.remove(index);
         return new ApiRespons("event deleted successfully");
    }
    @PutMapping("/update/{index}")
    public ApiRespons updateEvent(@RequestBody Event event, @PathVariable int index) {
         events.set(index, event);
         return new ApiRespons("event updated successfully");
    }
    @GetMapping("/serchbyid/{id}")
    public ArrayList<Event> getEventsById(@PathVariable String id) {
         ArrayList<Event> searchEvents = new ArrayList<>();
         for (Event event : events) {
             if (event.getId().equals(id)) {
                 searchEvents.add(event);
             }

         }
        return searchEvents;
    }
    @PutMapping("/change/{index}/{capacity}")
    public ApiRespons changeCapacity(@PathVariable int index,@PathVariable int capacity) {
         events.get(index).setCapacity(capacity);
         return new ApiRespons("event updated successfully");
    }
}
