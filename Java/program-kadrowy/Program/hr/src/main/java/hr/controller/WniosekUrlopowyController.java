package hr.controller;

import java.sql.Date;
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

import hr.model.Pracownik;
import hr.model.Status;
import hr.model.WniosekUrlopowy;
import hr.repository.WniosekUrlopowyRepository;
import hr.service.WniosekUrlopowyService;

@Controller
public class WniosekUrlopowyController {

    @Autowired
    private WniosekUrlopowyRepository wniosekUrlopowyRepository;
    
    @Autowired
    private WniosekUrlopowyService wniosekUrlopowyService;
    
    
    @GetMapping("/wniosekurlopowy")
	public String showPage (Model model, @RequestParam(defaultValue="0") int page) {
		model.addAttribute("data", wniosekUrlopowyRepository.findAll(PageRequest.of(page, 4, Sort.unsorted())));
		model.addAttribute("currentPage", page);
		return "html/wniosekurlopowy";
    }
    
    @GetMapping("/urlopydoakceptacji")
	public String showAcceptancePage (Model model, @RequestParam(defaultValue="0") int page) {
		model.addAttribute("data", wniosekUrlopowyRepository.findAll(PageRequest.of(page, 4, Sort.unsorted())));
		model.addAttribute("currentPage", page);
		return "html/urlopydoakceptacji";
    }
    
	@GetMapping("/wniosekurlopowy/deletewniosekurlopowy")
	public String deleteWniosekurlopowy(Integer id)
	{
		wniosekUrlopowyRepository.deleteById(id);
		return "redirect:/wniosekurlopowy/";
	}
	
	@GetMapping("/wniosekurlopowy/findOnewniosekurlopowy")
	@ResponseBody
	public Optional<WniosekUrlopowy> findOne(Integer id)
	{
		return wniosekUrlopowyRepository.findById(id);
	}
	
	@GetMapping("/wniosekurlopowy/akceptujwniosekurlopowy/")
	public String akceptujWniosek(Integer id)
	{
		Optional<WniosekUrlopowy> wniosekUrlopowy = wniosekUrlopowyRepository.findById(id);
		String name = wniosekUrlopowy.orElse(new WniosekUrlopowy()).getName();
		Pracownik pracownik = wniosekUrlopowy.orElse(new WniosekUrlopowy()).getPracownik();
		Status status = wniosekUrlopowy.orElse(new WniosekUrlopowy()).getStatus();
		Date odkiedy = wniosekUrlopowy.orElse(new WniosekUrlopowy()).getOdkiedy();
		Date dokiedy = wniosekUrlopowy.orElse(new WniosekUrlopowy()).getDokiedy();
		
		if(status==Status.OCZEKUJE)
		{

			WniosekUrlopowy wniosekUrlopowyZaakceptowany = new WniosekUrlopowy();
			wniosekUrlopowyZaakceptowany.setId(id);
			wniosekUrlopowyZaakceptowany.setName(name);
			wniosekUrlopowyZaakceptowany.setPracownik(pracownik);
			wniosekUrlopowyZaakceptowany.setStatus(Status.ZATWIERDZONY);
			wniosekUrlopowyZaakceptowany.setOdkiedy(odkiedy);
			wniosekUrlopowyZaakceptowany.setDokiedy(dokiedy);
			
			wniosekUrlopowyRepository.save(wniosekUrlopowyZaakceptowany);
		}
		return "redirect:/urlopydoakceptacji";
	}
	
	@GetMapping("/wniosekurlopowy/odrzucwniosekurlopowy/")
	public String odrzucWniosek(Integer id)
	{
		Optional<WniosekUrlopowy> wniosekUrlopowy = wniosekUrlopowyRepository.findById(id);
		String name = wniosekUrlopowy.orElse(new WniosekUrlopowy()).getName();
		Pracownik pracownik = wniosekUrlopowy.orElse(new WniosekUrlopowy()).getPracownik();
		Status status = wniosekUrlopowy.orElse(new WniosekUrlopowy()).getStatus();
		Date odkiedy = wniosekUrlopowy.orElse(new WniosekUrlopowy()).getOdkiedy();
		Date dokiedy = wniosekUrlopowy.orElse(new WniosekUrlopowy()).getDokiedy();
		
		if(status==Status.OCZEKUJE)
		{

			WniosekUrlopowy wniosekUrlopowyOdrzucony = new WniosekUrlopowy();
			wniosekUrlopowyOdrzucony.setId(id);
			wniosekUrlopowyOdrzucony.setName(name);
			wniosekUrlopowyOdrzucony.setPracownik(pracownik);
			wniosekUrlopowyOdrzucony.setStatus(Status.ODRZUCONY);
			wniosekUrlopowyOdrzucony.setOdkiedy(odkiedy);
			wniosekUrlopowyOdrzucony.setDokiedy(dokiedy);
			
			
			wniosekUrlopowyRepository.save(wniosekUrlopowyOdrzucony);
		}
		
		return "redirect:/urlopydoakceptacji";
	}
	
	@PostMapping("/wniosekurlopowy/savewniosekurlopowy")
	public String save(WniosekUrlopowy wniosekurlopowy)
	{
		wniosekUrlopowyRepository.save(wniosekurlopowy);
		return "redirect:/wniosekurlopowy/";
	}
}
