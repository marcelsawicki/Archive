package hr.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hr.model.Departament;
import hr.model.Pracownik;
import hr.repository.PracownikRepository;
import hr.service.PracownikService;

@Controller
public class PracownikController {
	
    @Autowired
    private PracownikRepository pracownikRepository;
    
    @Autowired
    private PracownikService pracownikService;
    
    
    @GetMapping("/pracownik")
	public String showPage (Model model, @RequestParam(defaultValue="0") int page) {
		model.addAttribute("data", pracownikRepository.findAll(PageRequest.of(page, 4, Sort.unsorted())));
		model.addAttribute("currentPage", page);
		return "html/pracownik";
    }
    
	@GetMapping("/pracownik/deletepracownik")
	public String deletePracownik(Integer id)
	{
		pracownikRepository.deleteById(id);
		return "redirect:/pracownik/";
	}
	
	@GetMapping("/pracownik/findOnepracownik")
	@ResponseBody
	public Optional<Pracownik> findOne(Integer id)
	{
		return pracownikRepository.findById(id);
	}
	
	@PostMapping("/pracownik/savepracownik")
	public String save(Pracownik pracownik)
	{
		pracownikRepository.save(pracownik);
		return "redirect:/pracownik/";
	}
}
