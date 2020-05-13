package departament.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import departament.model.Country;
import departament.model.Department;
import departament.model.Response;
import departament.repository.AppUserRepository;
import departament.repository.DepartmentRepository;
import departament.service.DepartmentService;
import departament.service.AppUserService;

@Controller
public class DepartmentController {
	
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private AppUserService appUserService;
    
    
    @GetMapping("/dept")
	public String showPage (Model model, @RequestParam(defaultValue="0") int page) {
		model.addAttribute("data", departmentRepository.findAll(PageRequest.of(page, 4, Sort.unsorted())));
		model.addAttribute("currentPage", page);
		return "html/dept";
    }
		
	@GetMapping("/dept/deletedept")
	public String deleteDepartment(Integer id)
	{
		departmentRepository.deleteById(id);
		return "redirect:/dept/";
	}
	
	@GetMapping("/dept/findOnedept")
	@ResponseBody
	public Optional<Department> findOne(Integer id)
	{
		return departmentRepository.findById(id);
	}
	
	@PostMapping("/dept/savedept")
	public String save(Department department)
	{
		departmentRepository.save(department);
		return "redirect:/dept/";
	}
	
	@GetMapping("/get")
	public String get() 
	{
		return departmentRepository.findAll().toString();
	}

	@GetMapping("/employes")
	public String employes() 
	{
		return departmentService.findDepartmentWithMaxNumberOfEmployes().toString();
	}
	
	@GetMapping("/salary")
	public String salary() 
	{
		return departmentService.findDepartmentWithMaxUsersSalary().toString();
	}
	
	/* Zadanie 3: a) zsumowanie rocznych wyplad dla dzialu (DEPARTAMENT_NAME) */
	@GetMapping(value="/sumyearsalary/{nazwa}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Response sumyearsalary(@PathVariable("nazwa") String nazwa) 
	{
		long result = departmentService.sumYearSalary(nazwa);
		String finalResult = Long.toString(result);
		return new Response(1,finalResult);
	}
	
	/* Zadanie 3: a) zsumowanie rocznych wyplad dla dzialu (DEPARTAMENT_NAME) */
	@GetMapping(value="/sumyearsalaryfront/{nazwa}")
	public String showPagesalary (Model model,@PathVariable("nazwa") String nazwa) {
		long result = departmentService.sumYearSalary(nazwa);
		String finalResult = Long.toString(result);
		model.addAttribute("data", finalResult);
		return "html/yearsalary";
    }
	
	
	/* Zadanie 3: c) miesieczne podatko od wynagrodzen dla firmy, dla przekazanej jako parametr
	 * wysokosci (procentowej) podatku
	 */
	@GetMapping(value="/gettax/{nazwa}/{podatek}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Response sumyearsalary(@PathVariable("nazwa") String nazwa, @PathVariable("podatek") double podatek) 
	{
		double result = departmentService.getYearTax(nazwa,podatek);
		String finalResult = Double.toString(result);
		return new Response(1,finalResult);
	}
	
    @GetMapping(value="/gettaxfront/{nazwa}/{podatek}")
	public String showPage (Model model, @PathVariable("nazwa") String nazwa, @PathVariable("podatek") double podatek) {
		double result = departmentService.getYearTax(nazwa,podatek);
		String finalResult = Double.toString(result);
		model.addAttribute("data", finalResult);
		return "html/tax";
    }

}
