package hr.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.domain.Sort;

import hr.model.Departament;
import hr.repository.DepartamentRepository;
import hr.service.DepartamentService;

@Controller
public class DepartamentController {
	
    @Autowired
    private DepartamentRepository departamentRepository;
    
    @Autowired
    private DepartamentService departamentService;
    
    @GetMapping("/departament")
	public String showPage (Model model, @RequestParam(defaultValue="0") int page) {
		model.addAttribute("data", departamentRepository.findAll(PageRequest.of(page, 4, Sort.unsorted())));
		model.addAttribute("currentPage", page);
		return "html/departament";
    }
    
	@GetMapping("/departament/deletedepartament")
	public String deleteDepartament(Integer id)
	{
		departamentRepository.deleteById(id);
		return "redirect:/departament/";
	}
	
	@GetMapping("/departament/findOnedepartament")
	@ResponseBody
	public Optional<Departament> findOne(Integer id)
	{
		return departamentRepository.findById(id);
	}
	
	@PostMapping("/departament/savedepartament")
	public String save(Departament departament)
	{
		departamentRepository.save(departament);
		return "redirect:/departament/";
	}

}
