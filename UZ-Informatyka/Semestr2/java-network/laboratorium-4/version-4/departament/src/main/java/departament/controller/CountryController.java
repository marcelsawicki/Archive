package departament.controller;

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

import departament.model.Country;
import departament.repository.CountryRepository;

@Controller
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping("/")
	public String showMenu () {
		return "html/index";
	}
	
	@GetMapping("/country")
	public String showPage (Model model, @RequestParam(defaultValue="0") int page) {
		model.addAttribute("data", countryRepository.findAll(PageRequest.of(page, 4, Sort.unsorted())));
		model.addAttribute("currentPage", page);
		return "html/country";
		
	}
	
	@PostMapping("/country/save")
	public String save(Country country)
	{
		countryRepository.save(country);
		return "redirect:/country/";
	}
	
	@GetMapping("/country/delete")
	public String deleteCountry(Integer id)
	{
		countryRepository.deleteById(id);
		return "redirect:/country/";
	}
	
	@GetMapping("/country/findOne")
	@ResponseBody
	public Optional<Country> findOne(Integer id)
	{
		return countryRepository.findById(id);
	}
	
}
