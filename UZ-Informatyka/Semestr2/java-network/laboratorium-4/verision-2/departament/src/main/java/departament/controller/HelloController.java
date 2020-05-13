package departament.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import departament.model.Response;
import departament.model.WatchListItem;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestAttribute;

@SuppressWarnings("deprecation")
@Controller
@RequestMapping(value="/api", method=RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
public class HelloController {
	List<WatchListItem> watchListItems = new ArrayList<WatchListItem>();
	
	@GetMapping(value="/hello", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Response hello() {
		return new Response(1,
				"Hello World!");

	}
	
	@GetMapping("/front")
	public String front(Model model) {
		model.addAttribute("title", "Hello World!");
		return "html/front";
	}
	
	@GetMapping("/watchlist")
	public ModelAndView lista() {
		String viewName = "html/watchlist";
		Map<String, Object> model = new HashMap<String, Object>();
		
		watchListItems.clear();
		watchListItems.add(new WatchListItem("Lion King","8.5","high","Hakuna matata!"));
		watchListItems.add(new WatchListItem("Frozen","7.5","medium","Let it go!"));
		watchListItems.add(new WatchListItem("Cars","7.1","low","Go go go!"));
		watchListItems.add(new WatchListItem("Wall-E","8.4","high","You are crying!"));
		
		model.put("watchlistItems", watchListItems);
		model.put("numberOfMovies", watchListItems.size());
		
		return new ModelAndView(viewName , model);
	}

}