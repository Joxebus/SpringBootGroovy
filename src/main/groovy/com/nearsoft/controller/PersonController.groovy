package com.nearsoft.controller

import com.nearsoft.domain.Person
import com.nearsoft.service.PersonService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping('/person')
@Slf4j
class PersonController {

    @Autowired
    PersonService personService

    /**
     * Returns a model and view to display the information
     * @param model contains the info to render
     * @return view
     */
    @GetMapping(value='/')
    def list(Model model){
        List<Person> personList = personService.findAll()
        model.addAttribute('personList', personList)
        'person/list'
    }

    @GetMapping("/new")
    def newPerson(Model model){
        log.info 'Calling create method'
        model.addAttribute("person", new Person())
        'person/create'
    }

    @PostMapping("/create")
    def createPerson(@ModelAttribute Person person, RedirectAttributes redirAttrs){
        log.info 'Calling create method'
        personService.save(person)
        redirAttrs.addFlashAttribute("message", "Successfuly added ${person.name}")
        'redirect:/person/'
    }

    // API Rest

    @GetMapping(value='/api',
            produces = MediaType.APPLICATION_JSON_VALUE)
    def @ResponseBody List<Person> restList(){
        log.info "Get list of persons as JSON"
        personService.findAll()
    }

    @PostMapping(value='/api',
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    def @ResponseBody Person restSave(@RequestBody Person person){
        log.info "Saving person $person"
        personService.save(person)
    }

    @PutMapping(value='/api',
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    def @ResponseBody Person restUpdate(@RequestBody Person person){
        log.info "Updating person $person"
        personService.save(person)
    }

    @GetMapping(value='/api/{id}',
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    def @ResponseBody Person restGetPerson(@PathVariable Long id){
        log.info "Get person with id: $id"
        personService.findById(id)
    }

    @DeleteMapping(value='/api/{id}',
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    def @ResponseBody ResponseEntity<?> restDeletePerson(@PathVariable Long id){
        log.info "Delete person with id: $id"
        HttpStatus status = null;
        try{
            if(personService.delete(id)){
                log.debug("SUCCESS")
                status = HttpStatus.OK
            }else{
                log.error("ERROR")
                status = HttpStatus.UNPROCESSABLE_ENTITY
            }

        }catch(Error e){
            log.error(e.getMessage())
            status =HttpStatus.BAD_REQUEST
        }
        return new ResponseEntity<String>(status)
    }
}