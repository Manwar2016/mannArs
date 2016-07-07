package com.igate.ars.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.igate.ars.dto.AirportDTO;
import com.igate.ars.dto.BookingInfoDTO;
import com.igate.ars.dto.CreditCardDTO;
import com.igate.ars.dto.FlightInfoDTO;
import com.igate.ars.dto.LoginDTO;
import com.igate.ars.dto.PassengerDTO;
import com.igate.ars.dto.SeatInfoDTO;
import com.igate.ars.dto.UserDTO;
import com.igate.ars.exception.ArsException;
import com.igate.ars.service.IArsService;

@Controller
public class ArsController {

	@Autowired
	private IArsService arsService;
	UserDTO userDTO;
	public static final Logger logger =  Logger.getRootLogger();  
	public ArsController(){	
		PropertyConfigurator.configure("D:/Manwar_Works/work/ARS/Source/AirlineReservationSystem/WebContent/resources/log4j.properties");
	}

	/*******************************************************************************************
	 * Method Name: String loadForm(Model model)
	 * Return type:String
	 * Parameters:Object of type Model,Request Parameter
	 * Description: This method load the login page into browser. 
	 * @author Manwar Singh
	 ********************************************************************************************/
	@RequestMapping(value="loadLogin")
	public String loadLoginForm(Model model){
		model.addAttribute("loginDTO",new LoginDTO());
		return "ARS_Common_login"; 
	}


	/*******************************************************************************************
	 * Method Name: String processLogOut(@RequestParam("option") String option,Model model)
	 * Return type:String
	 * Parameters:Object of type Model,HttpServletRequest request
	 * Description:This method invalidate the current session and redirect the user to login page 
	 * @author Manwar Singh
	 ********************************************************************************************/
	@RequestMapping(value="logOut")
	public String processLogOut(Model model,HttpServletRequest request){
		request.getSession().invalidate();
		model.addAttribute("loginDTO",new LoginDTO());
		return "ARS_Common_login"; 
	}


	/*******************************************************************************************
	 * Method Name: String loadHomePage(Model model,HttpServletRequest request)
	 * Return type:String
	 * Parameters:Object of type Model,HttpServletRequest
	 * Description:This method return the user to their respective home page based on the role. 
	 * @author Manwar Singh
	 ********************************************************************************************/
	@RequestMapping(value="loadHome" ,method=RequestMethod.GET)
	public String loadHomePage(Model model,HttpServletRequest request){
		HttpSession session = request.getSession();

		String role=(String) session.getAttribute("userRole");
		if("admin".equals(role))
			return "ARS_Admin_Homepage";
		else if("executive".equals(role))
			return "ARS_Executive_Homepage";
		else if("user".equals(role))
			return "ARS_Customer_Homepage";
		return "ARS_Common_login";
	}


	/**********************************************************************************
	 * Method Name: String checkLogin(@ModelAttribute("userDTO") @Valid UserDTO userDTO,BindingResult result,Model model)
	 * Return type:String
	 * Parameters:Object of type Model,BindingResult and LoginDTO
	 * Description:This method returns the name of the view that is to be displayed on
	 * the browser on home page if login success otherwise in login page with error message. 
	 * @author Manwar Singh
	 ***********************************************************************************/


	@RequestMapping(value="processLogin")
	public String processLoginForm(@ModelAttribute("loginDTO") @Valid LoginDTO loginDTO,BindingResult result,Model model,HttpServletRequest request)
	{

		if(result.getFieldError("userName")!=null)
		{ 
			return "ARS_Common_login";
		}
		if(result.getFieldError("password")!=null)
		{ 
			model.addAttribute("error","Invalid Username/Password");
			return "ARS_Common_login";
		}

		userDTO = new UserDTO();
		userDTO.setUserName(loginDTO.getUserName());
		userDTO.setPassword(loginDTO.getPassword());
		try{

			userDTO=arsService.isValidLogin(userDTO);
			HttpSession session= request.getSession();
			if(userDTO.isUserStatus()==false)
			{
				model.addAttribute("loginDTO",new LoginDTO());
				model.addAttribute("error","Invalid Username/Password");
				return "ARS_Common_login";
			}
			else if("user".equals(userDTO.getRole()))
			{

				session.setAttribute("userName", userDTO.getUserName());
				session.setAttribute("userRole", userDTO.getRole());
				session.setAttribute("userId", userDTO.getUserId());
				logger.info(userDTO.getUserName()+" logged in sucessfully having role "+userDTO.getRole()+"at "+new Date());
				model.addAttribute("flightInfoDTO",new FlightInfoDTO());
				return "ARS_Customer_Homepage";
			}
			else if("admin".equals(userDTO.getRole()))
			{    
				session.setAttribute("userName", userDTO.getUserName());
				session.setAttribute("userId", userDTO.getUserId());
				session.setAttribute("userRole", userDTO.getRole());
				logger.info(userDTO.getUserName()+" logged in sucessfully having role "+userDTO.getRole()+"at "+new Date());
				return "ARS_Admin_Homepage";
			}
			else
			{
				session.setAttribute("userName", userDTO.getUserName());
				session.setAttribute("userId", userDTO.getUserId());
				session.setAttribute("userRole", userDTO.getRole());
				logger.info(userDTO.getUserName()+" logged in sucessfully having role "+userDTO.getRole()+"at "+new Date());
				return "ARS_Executive_Homepage";
			}
		}

		catch(DataAccessException exception)
		{
			model.addAttribute("error","exceptionuser name does not exist in database");
			System.out.println(exception.getMessage());
			return "ARS_All_Error";
		}

	}


	/**********************************************************************************
	 * Method Name: String loadSignUpForm(Model model)
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the name of the user registration view
	 * @author Manwar Singh
	 ***********************************************************************************/

	@RequestMapping(value="loadSignup")
	public String loadSignUpForm(Model model){
		model.addAttribute("userDTO",new UserDTO());
		return "ARS_User_signup"; 
	}

	/**********************************************************************************
	 * Method Name: String addUser(@ModelAttribute("userDTO") @Valid UserDTO userDTO,BindingResult result,Model model)
	 * Return type:String
	 * Parameters:Object of type Model,BindingResult and UserDTO
	 * Description:This method returns the name of the view that is to be displayed on
	 * the browser on home page if sign up happens successfully otherwise in error page with error message
	 * for in the same page if invalid input given by the user. 
	 * @author Manwar Singh
	 ***********************************************************************************/


	@RequestMapping(value="addUser")
	public String addUserForm(@ModelAttribute("userDTO") @Valid UserDTO userDTO,BindingResult result,Model model)
	{
		if(!userDTO.getPassword().equals(userDTO.getConfirmPassword()))
		{ 
			model.addAttribute("passwordValidMsg","password did not matched");
			return "ARS_User_signup";
		}
		int count=0;
		if(result.hasErrors()){
			return "ARS_User_signup";
		}

		try{
			count = arsService.addUser(userDTO);
			if(count > 0)
			{
				model.addAttribute("sucessMsg", "signup sucessfully");
				logger.info(userDTO.getUserName()+" registered  sucessfully"+"at "+new Date());
				model.addAttribute("loginDTO",new LoginDTO());
				return "ARS_Common_login";
			}
		}

		catch(DataAccessException exception)
		{
			model.addAttribute("error",exception.getMessage());
			logger.error(exception.getMessage());
			return "ARS_All_Error";
		}

		return "ARS_Common_login";
	}

	/**********************************************************************************
	 * Method Name: String loadAddFlightForm(Model model)
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the name of the view that is to be displayed on
	 * the browser that is addFlights form
	 * @author Manwar Singh
	 ***********************************************************************************/

	@RequestMapping(value="loadAddFlight")
	public String loadAddFlightForm(Model model,HttpServletRequest request){

		try {
			HttpSession session = request.getSession();
			List<AirportDTO> airportList = arsService.getAirport();
			session.setAttribute("airportList", airportList);
			model.addAttribute("airportList",airportList);
			model.addAttribute("flightInfoDTO",new FlightInfoDTO());  

		} 
		catch (DataAccessException exception) {
			model.addAttribute("error",exception.getMessage());
			logger.error(exception.getMessage());
			return "ARS_All_Error";
		}
		return "ARS_Admin_addFlight";

	}

	/***********************************************************************************
	 * Method Name: String processAddFlightForm(@ModelAttribute("flightInfoDTO") 
	 * @Valid FlightInfoDTO flightInfoDTO,BindingResult result,Model model,HttpServletRequest request)
	 * Return type:String
	 * Parameters:Object of type Model,BindingResult and FlightInfoDTO
	 * Description:This method get the flight information from the ARS_Admin_addFlight form and add into the database
	 * @author Manwar Singh
	 ***********************************************************************************/

	@RequestMapping(value="processAddFlight")
	public String processAddFlightForm(@ModelAttribute("flightInfoDTO") @Valid FlightInfoDTO flightInfoDTO,BindingResult result,
			Model model,HttpServletRequest request)
	{
		

		if(result.hasErrors())
		{
			
			
			if(result.hasFieldErrors("departureDate"))
				model.addAttribute("deptDateError","Departure date should be in format(yyyy-mm-dd)");
			List<AirportDTO> airportList;
			airportList = arsService.getAirport();
			model.addAttribute("airportList",airportList);
			return "ARS_Admin_addFlight";
		}
		
		if(flightInfoDTO.getDepartureAirportId().equals(flightInfoDTO.getArrivalAirportId()))
				{
					model.addAttribute("sameAirportError","Arrival and Departure airport cannot be same");
					return "ARS_Admin_addFlight";
				}
		if(flightInfoDTO.getBusinessSeats()==0){
			model.addAttribute("bussseatError","Please Enter the number of business class seat");
			return "ARS_Admin_addFlight";
		}

		if(flightInfoDTO.getBusinessSeatFare()==0.0){
			model.addAttribute("bussseatFareError","Please Enter the fare for business class seat");
			return "ARS_Admin_addFlight";
		}
		if(flightInfoDTO.getFirstSeats()==0){
			model.addAttribute("firstseatError","Please Enter the number of First classs seat");
			return "ARS_Admin_addFlight";
		}
		if(flightInfoDTO.getFirstSeatFare()==0.0){
			model.addAttribute("firstseatFareError","Please Enter the fare for First classs seat");
			return "ARS_Admin_addFlight";
		}

		if(flightInfoDTO.getDepartureTime().equals(flightInfoDTO.getArrivalTime())){
			model.addAttribute("sameTimeError","Sorry departure time and arrival time cannot be same");
			return "ARS_Admin_addFlight";
		}

		//arrivalDate should be after departure date
		//arrival time should be after departure time

		int count =0;
		try {
			count= arsService.addFlightInfo(flightInfoDTO);
			if(count>0)
			{
				model.addAttribute("successMsg","Flight is added successully");
			}
			else
			{
				model.addAttribute("error","flight is not added");
				return "ARS_All_Error";
			}
		}
		catch (DataAccessException exception) {
			System.out.println(exception.getMessage());
			model.addAttribute("error",exception.getMessage());
			logger.error(exception.getMessage());
			return "error";
		}
		return "ARS_Admin_addFlight";
	}


	/*******************************************************************************************
	 * Method Name: String loadUpdateFlightForm(Model model)
	 * Return type:String
	 * Parameters:Object of type Model,Request Parameter
	 * Description: This method return the admin to the update flight page 
	 * @author Manwar Singh
	 ********************************************************************************************/
	
	@RequestMapping(value="loadUpdateFlight")
	public String loadUpdateFlightForm(Model model){

		try {
			List<FlightInfoDTO> flightNumbersList = arsService.getFlightNumbers();
			if(flightNumbersList.size()==0)
			{
				model.addAttribute("error","No flight is available for update");
				return "ARS_Admin_updateFlight";
			}
			model.addAttribute("flightNumbersList",flightNumbersList);
			model.addAttribute("flightInfoDTO",new FlightInfoDTO());  
		} 
		catch (DataAccessException exception) {
			model.addAttribute("error",exception.getMessage());
			return "ARS_All_Error";
		}

		return "ARS_Admin_updateFlight"; 
	}


	/**********************************************************************************
	 * Method Name: String loadCancelFlightForm(Model model)
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the name of the user cancel flight form view
	 * @author Manwar Singh
	 ***********************************************************************************/

	@RequestMapping(value="cancelFlight")
	public String loadCancelFlightForm(Model model){
		model.addAttribute("flightInfoDTO",new FlightInfoDTO());
		return "ARS_Admin_CancelFlight"; 
	}



	/**********************************************************************************
	 * Method Name: String loadCancelFlightForm(@ModelAttribute("flightInfoDTO") @Valid FlightInfoDTO flightInfoDTO,BindingResult result,Model model)
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the name of the user cancel flight form view
	 * @author Manwar Singh
	 ***********************************************************************************/

	@RequestMapping(value="processCancelFlightForm")
	public String processCancelFlightForm(@ModelAttribute("flightInfoDTO") @Valid FlightInfoDTO flightInfoDTO,BindingResult result,Model model,HttpServletRequest request){


		if(result.getFieldError("departureDate")!=null)
		{   
			return "ARS_Admin_CancelFlight"; 
		}

		try {

			List<FlightInfoDTO> flightInfoList=arsService.getFlightInfoList(flightInfoDTO.getDepartureDate());
			request.getSession().setAttribute("flightInfoList",flightInfoList); 
			request.getSession().setAttribute("departureDate",flightInfoDTO.getDepartureDate());  
		} 
		catch (DataAccessException exception) {
			model.addAttribute("error",exception.getMessage());
			return "ARS_All_Error";
		}    
		return "ARS_Admin_CancelFlight"; 
	}

	/**********************************************************************************
	 * Method Name: String processCancelFlights(@RequestParam("flightNo") String flightNo, Model model)
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the user to cancel flight form view
	 * @author Manwar Singh
	 ***********************************************************************************/

	@RequestMapping(value="processCancelFlight" , method=RequestMethod.GET)
	public String processCancelFlights(@RequestParam("flightNo") String flightNo, Model model, HttpServletRequest request){
		try {


			System.out.println("I am in process cancel flight");
			int count = arsService.cancelFlight(flightNo); 
			if(count==0)
			{
				model.addAttribute("error", "There is already booking for this flight, you can not cancel");
			}
			else
			{		List<FlightInfoDTO> flightInfoList=arsService.getFlightInfoList((Date)request.getSession().getAttribute("departureDate"));
			request.getSession().setAttribute("flightInfoList",flightInfoList); 
			model.addAttribute("sucessMsg",flightNo+" Flight is cancelled successully"); 
			}
		} 
		catch (DataAccessException exception) {
			model.addAttribute("error",exception.getMessage());
			return "ARS_Admin_CancelFlight";
		}  
		model.addAttribute("flightInfoDTO",new FlightInfoDTO());
		return "ARS_Admin_CancelFlight"; 
	}



	/*******************************************************************************************
	 * Method Name: String getFlightInfo(@ModelAttribute("flightInfoDTO") @Valid FlightInfoDTO flightInfoDTO,BindingResult result,Model model)
	 * Return type:String
	 * Parameters:Object of type Model,Request Parameter
	 * Description:This method returns the name of the view that is to be displayed on
	 * the browser that is ARS_admin_updateFlight page. 
	 * @author Manwar Singh
	 ********************************************************************************************/
	@RequestMapping(value="getFlightInfo")
	public String getFlightInfo(@ModelAttribute("flightInfoDTO") @Valid FlightInfoDTO flightInfoDTO,BindingResult result,Model model){


		if(result.getFieldError("flightNo")!=null)
		{   
			return "ARS_Admin_updateFlight"; 
		}

		try {
			List<FlightInfoDTO> flightInfoList=arsService.getFlightInfoList(flightInfoDTO.getFlightNo());
			List<FlightInfoDTO> flightNumbersList = arsService.getFlightNumbers();
			if(flightNumbersList.size()==0)
			{
				model.addAttribute("error","no flight is availble for update");
			}
			model.addAttribute("flightNumbersList",flightNumbersList);
			model.addAttribute("flightInfoList",flightInfoList);  
		} 
		catch (DataAccessException exception) {
			model.addAttribute("error",exception.getMessage());
			return "ARS_All_Error";
		}    
		return "ARS_Admin_updateFlight"; 
	}


	/**********************************************************************************
	 * Method Name: String loadUpdateFlightForm(Model model)
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the name of the view that is to be displayed on
	 * the browser that is addFlights form
	 * @author Manwar Singh
	 ***********************************************************************************/

	@RequestMapping(value="loadUpdateFlightForm" , method=RequestMethod.GET)
	public String loadUpdateFlight(@RequestParam("flightNo") String flightNo,Model model,HttpServletRequest request){
		try {
			FlightInfoDTO flightInfoDTO = arsService.getFlightInfo(flightNo);
			List<AirportDTO> airportList = arsService.getAirport();
			request.getSession().setAttribute("airportList", airportList);
			model.addAttribute("airportList",airportList);
			model.addAttribute("flightInfoDTO",flightInfoDTO);
		}
		catch (DataAccessException exception) {
			exception.printStackTrace();
			model.addAttribute("error",exception.getMessage());
			return "ARS_All_Error";
		}   
		return "ARS_Admin_updateflight_form";

	}


	/**********************************************************************************
	 * Method Name: String processUpdateFlightForm(Model model)
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the name of the view that is to be displayed on
	 * the browser that is addFlights form
	 * @author Manwar Singh
	 ***********************************************************************************/
	@RequestMapping(value="processUpdateFlightForm" , method=RequestMethod.POST)
	public String processUpdateFlight(@ModelAttribute("flightInfoDTO") @Valid FlightInfoDTO flightInfoDTO,BindingResult result ,Model model, HttpServletRequest request){


		if(result.hasErrors())
		{

			model.addAttribute("airportList",request.getSession().getAttribute("airportList"));
			return "ARS_Admin_updateflight_form";
		}

		if(flightInfoDTO.getBusinessSeats()==0){

			model.addAttribute("bussseatError","Please Enter the number of business class seat");
			return "ARS_Admin_updateflight_form";

		}

		if(flightInfoDTO.getBusinessSeatFare()==0.0){

			model.addAttribute("bussseatFareError","Please Enter the fare for business class seat");
			return "ARS_Admin_updateflight_form";

		}
		if(flightInfoDTO.getFirstSeats()==0){
			model.addAttribute("firstseatError","Please Enter the number of First classs seat");
			return "ARS_Admin_updateflight_form";
		}
		
		if(flightInfoDTO.getFirstSeatFare()==0.0){
			model.addAttribute("firstseatFareError","Please Enter the fare for First classs seat");
			return "ARS_Admin_updateflight_form";
		}

		if(flightInfoDTO.getDepartureAirportId().equals(flightInfoDTO.getArrivalAirportId())){
			model.addAttribute("sameCityError","Sorry departure city and arrival city cannot be same");
			return "ARS_Admin_updateflight_form";
		}

		if(flightInfoDTO.getDepartureTime().equals(flightInfoDTO.getArrivalTime())){
			model.addAttribute("sameTimeError","Sorry departure time and arrival time cannot be same");
			return "ARS_Admin_updateflight_form";
		}

		try {
			int count = arsService.updateFlightInfo(flightInfoDTO);
			model.addAttribute("successMsg","Flight is updated successfully");
		}  
		catch (DataAccessException exception) {
			exception.printStackTrace();
			model.addAttribute("error",exception.getMessage());
			return "ARS_All_Error";
		}   
		return "ARS_Admin_updateflight_form";

	}








	/*_____________________________________________________________________________________________________________
	 * 
	 *                   						  VIEW REPORTS
	 *_____________________________________________________________________________________________________________*/

	/*******************************************************************************************
	 * Method Name: String loadViewReportForm(@RequestParam("option") String option,Model model)
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the  ARS_admin_viewReports page
	 * @author Manwar Singh
	 * @throws ArsException 
	 ********************************************************************************************/
	@RequestMapping(value="loadViewReport")
	public String loadViewReportForm(Model model ,HttpServletRequest request) throws ArsException
	{
		HttpSession session = request.getSession();
		List<FlightInfoDTO> flightNumbersList = arsService.getFlightNumbers();
		session.setAttribute("flightNumbersList",flightNumbersList);
		model.addAttribute("flightNumbersList",flightNumbersList);
		System.out.println("airportlist"+flightNumbersList);
		model.addAttribute("passengerDTO",new PassengerDTO()); 

		List<AirportDTO> airportList = arsService.getAirport();
		session.setAttribute("airportList",airportList);
		model.addAttribute("airportList",airportList);

		model.addAttribute("flightInfoDTO",new FlightInfoDTO());
		return "ARS_admin_viewReports"; 
	}	

	/*******************************************************************************************
	 * Method Name: String processViewFlightDetails(Model model)
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the  flight details based on specific date and destination place
	 * @author Himshikha Das
	 ********************************************************************************************/

	@RequestMapping(value="processViewFlightDetails" , method=RequestMethod.POST)
	public String processViewFlightDetails(@ModelAttribute("flightInfoDTO")  FlightInfoDTO flightInfoDTO,BindingResult result ,Model model, HttpServletRequest request) throws ArsException{

		{	
			try {
				HttpSession session = request.getSession();
				String departureAirportId =flightInfoDTO.getDepartureAirportId();
				Date departureDate = flightInfoDTO.getDepartureDate();

				List<FlightInfoDTO> allFlightList = arsService.retrieveFlightList(departureAirportId,departureDate);
				model.addAttribute("allFlightList",allFlightList);
				model.addAttribute("flightInfoDTO",new FlightInfoDTO());   


			} 
			catch (EmptyResultDataAccessException e) {

				model.addAttribute("exception","No record found!");
				return "ARS_All_Error";
			}

			return "ARS_admin_retrieveFlightList";
		}
	}
	/*******************************************************************************************
	 * Method Name: String processViewPassengerDetails(Model model)
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the passengers list of a specific flight
	 * @author Himshikha Das
	 ********************************************************************************************/


	@RequestMapping(value="processViewPassengerDetails" , method=RequestMethod.POST)
	public String processViewPassengerDetails(@ModelAttribute("flightInfoDTO")  FlightInfoDTO flightInfoDTO,PassengerDTO passengerDTO,BookingInfoDTO bookingInfoDTO,BindingResult result ,Model model, HttpServletRequest request) throws ArsException{

		{	
			try {

				String flightNo =bookingInfoDTO.getFlightNo();
				List<PassengerDTO> allPassenegerList = arsService.retrievePassengersList(flightNo);
				model.addAttribute("allPassenegerList",allPassenegerList);
				model.addAttribute("passengerDTO",new PassengerDTO()); 

			} 
			catch (EmptyResultDataAccessException e) {

				model.addAttribute("exception","No record found!");
				return "ARS_All_Error";
			}

			return "ARS_admin_retrievePassengerList";
		}

	}

	@RequestMapping(value="processViewBookingDetails" , method=RequestMethod.POST)
	public String processViewBookingDetails(@ModelAttribute("flightInfoDTO")  FlightInfoDTO flightInfoDTO,BookingInfoDTO bookinginfoDTO ,BookingInfoDTO bookingInfoDTO,BindingResult result ,Model model, HttpServletRequest request) throws ArsException{

		{	
			try {

				String flightNo =bookingInfoDTO.getFlightNo();
				List<BookingInfoDTO> viewBookingList = arsService.retrieveBookingList(flightNo);
				model.addAttribute("viewBookingList",viewBookingList);
				model.addAttribute("bookinginfoDTO",new BookingInfoDTO()); 

			} 
			catch (EmptyResultDataAccessException e) {

				model.addAttribute("exception","No record found!");
				return "ARS_All_Error";
			}

			return "ARS_admin_viewBookingList";
		}
	}


	/**********************************************************************************
	 * Method Name: loadUpdateBooking()
	 * Return type:String
	 * Parameters:@RequestParam("id") int bookingId,@ModelAttribute("passengerDTO") PassengerDTO passenger,Model model
	 * Description:This method returns the all the booking info and passengerInfo on the update 
	 * booking page
	 * @author Rajdeep Saha
	 ***********************************************************************************/

	@RequestMapping(value="loadUpdateBooking")
	public String loadUpdateBooking(@RequestParam("id") int bookingId,@ModelAttribute("passengerDTO") PassengerDTO passenger,Model model){
		try{
			List<PassengerDTO> passengersList=arsService.loadBookingList(bookingId);

			model.addAttribute("passengersList",passengersList);
		}
		catch(DataAccessException exception){

			model.addAttribute("errormessage",exception.getMessage());
			return "ARS_All_Error";

		}
		return "Ars_User_loadUpdateBooking";

	}
	/**********************************************************************************
	 * Method Name: getBookingList()
	 * Return type:String
	 * Parameters:@RequestParam("id") int passengerId,@ModelAttribute("passengerDTO") PassengerDTO passenger,Model model
	 * Description:This method returns the all the passengerInfo on the update 
	 * booking form
	 * @author Rajdeep Saha
	 ***********************************************************************************/


	@RequestMapping(value="getBookingList",method=RequestMethod.GET)
	public String getBookingList(@RequestParam("id") int passengerId,@ModelAttribute("passengerDTO") PassengerDTO passenger,Model model){
		try{
			PassengerDTO passengers=arsService.getBookingList(passengerId);
			model.addAttribute("passengers",passengers);
		}
		catch(DataAccessException exception){

			model.addAttribute("errormessage",exception.getMessage());
			return "ARS_All_Error";

		}

		return "Ars_User_UpdateBooking";

	}
	/**********************************************************************************
	 * Method Name: updateBooking()
	 * Return type:String
	 * Parameters:@ModelAttribute("passengerDTO") PassengerDTO passenger,Model model
	 * Description:This method returns the number of information updated into the database 
	 * @author Rajdeep Saha
	 ***********************************************************************************/

	@RequestMapping(value="updateBooking")
	public String updateBooking(@ModelAttribute("passengerDTO") @Valid  PassengerDTO passenger,BindingResult result,Model model){

		{
			if(result.hasErrors())
				return "Ars_User_UpdateBooking";
		}
		int count=0;
		try{
			count=arsService.updateBooking(passenger);
		}
		catch(DataAccessException exception){

			model.addAttribute("errormessage",exception.getMessage());
			return "error";

		}
		if(count!=0){

			return "success";
		}
		else

			return "failure";

	}
	/**********************************************************************************
	 * Method Name: viewBookings()
	 * Return type:String
	 * Parameters:Model model
	 * Description:This method returns all the booking details of a particular user
	 * @author Rajdeep Saha
	 ***********************************************************************************/

	@RequestMapping(value="viewBookings")
	public String viewBookings(Model model,HttpServletRequest request){

		try{
			String userId=(String) request.getSession().getAttribute("userId");
			List<BookingInfoDTO> bookingInfoList=arsService.getBookings(userId);
			model.addAttribute("bookingInfoList", bookingInfoList);
		}
		catch(DataAccessException exception){

			model.addAttribute("errormessage",exception.getMessage());
			return "ARS_All_Error";

		}


		return "Ars_User_ViewBooking";	
	}

	/**********************************************************************************
	 * Method Name: loadDeleteBooking()
	 * Return type:String
	 * Parameters:@RequestParam("id") int bookingId,Model model
	 * Description:This method returns all the booking details and passenger details
	 * on delete booking page
	 * @author Rajdeep Saha
	 ***********************************************************************************/

	@RequestMapping(value="loadDeleteBooking")
	public String loadDeleteBooking(@RequestParam("id") int bookingId,Model model){
		try{
			List<PassengerDTO> passengersList=arsService.loadBookingList(bookingId);
			model.addAttribute("passengersList", passengersList);
		}
		catch(DataAccessException exception){

			model.addAttribute("errormessage",exception.getMessage());
			return "ARS_All_Error";

		}



		return "Ars_User_LoadDeleteBooking";
	}
	/**********************************************************************************
	 * Method Name: viewBookings()
	 * Return type:String
	 * Parameters:Model model
	 * Description:This method returns number of booking passenger information 
	 * deleted into the database.
	 * @author Rajdeep Saha
	 ***********************************************************************************/

	@RequestMapping(value="processDeleteBooking")
	public String processDeleteBooking(@RequestParam("id") int passengerId,@ModelAttribute("passengerDTO") PassengerDTO passenger,Model model){
		int count=0;
		try{
			count=arsService.deleteBooking(passengerId);
		}
		catch(DataAccessException exception){

			model.addAttribute("errormessage",exception.getMessage());
			System.out.println(exception.getMessage());
			return "ARS_All_Error";

		}
		if(count!=0){
			return "success";
		}
		else
			return "failure";	
	}	

	//reservation module
	/**********************************************************************************
	 * Method Name: String loadSearchFlightForm(Model model)
	 * Return type:String
	 * Parameters: Model model
	 * Description:This method loads the seat reservation form on the browser
	 * @author Nikhil Pereira
	 ***********************************************************************************/

	@RequestMapping(value = "loadSearchFlightForm")
	String loadSearchFlightForm(Model model,HttpServletRequest request){
		try {
			List<AirportDTO> airportList= arsService.getAirportInfo();
			request.getSession().setAttribute("airportList", airportList);
			model.addAttribute("findFlightInfoDTO", new FlightInfoDTO());
		}
		catch (DataAccessException exception){
			model.addAttribute("error", "ARS Data Access Issues due to : "+exception);
			return "ARS_All_Error";
		}

		return "ARS_Customer_SearchFlightForm";
	}

	/**********************************************************************************
	 * Method Name: String loadSearchFlightList(Model model)
	 * Return type:String
	 * Parameters:flightInfoDTO , Model model
	 * Description:This method is invoked when the user clicks search flight button 
	 * in ARS_Customer_SearchFlightForm.jsp
	 * This method loads the list of flights searched for 
	 * @author Nikhil Pereira
	 ***********************************************************************************/

	@RequestMapping(value = "loadSearchFlightList")
	String loadSearchFlightList(@ModelAttribute("findFlightInfoDTO")  
	@Valid FlightInfoDTO findFlightInfoDTO,BindingResult result,
	Model model, HttpServletRequest request){

		if(result.getFieldError("departureAirportId")!=null)
		{   
			request.getSession().getAttribute("airportList");
			return "ARS_Customer_SearchFlightForm";
		}
		if(result.getFieldError("arrivalAirportId")!=null)
		{  
			request.getSession().getAttribute("airportList");
			return "ARS_Customer_SearchFlightForm";
		}

		if(findFlightInfoDTO.getArrivalAirportId().equals(findFlightInfoDTO.getDepartureAirportId()))
		{
			model.addAttribute("cityError", "Can not be same departure city and arrival city");
			request.getSession().getAttribute("airportList");
			return "ARS_Customer_SearchFlightForm";
		}
		if(result.getFieldError("departureDate")!=null)
		{	request.getSession().getAttribute("airportList");
		return "ARS_Customer_SearchFlightForm";
		}
		if(result.getFieldError("numPassengers")!=null)
		{	request.getSession().getAttribute("airportList");
		return "ARS_Customer_SearchFlightForm";
		}
		if(result.getFieldError("classType")!=null)
		{
			request.getSession().getAttribute("airportList");
			return "ARS_Customer_SearchFlightForm";
		}
		if(findFlightInfoDTO.getNumPassengers()==0)
		{
			model.addAttribute("numError", "number of passenger cant not be zero");
			request.getSession().getAttribute("airportList");
			return "ARS_Customer_SearchFlightForm";
		}

		try {
			HttpSession session = request.getSession();
			session.setAttribute("findFlightInfoDTO", findFlightInfoDTO);
			List<FlightInfoDTO> flightInfoList= arsService.findFlights(findFlightInfoDTO);
			if(flightInfoList.size()==0)
			{   model.addAttribute("findFlightInfoDTO", new FlightInfoDTO());
			model.addAttribute("errorMsg","There are no flights for the chosen date");
				return "ARS_Customer_SearchFlightForm";
			}
			session.setAttribute("flightInfoList", flightInfoList);
		} 
		catch (DataAccessException exception){
			model.addAttribute("error", "Unable to find flights. ARS Data Access Issues due to : "+exception);
			return "ARS_All_Error";
		}
		return "ARS_Customer_SearchFlightList";
	}


	/**********************************************************************************
	 * Method Name: String processBookSeats(Model model)
	 * Return type:String
	 * Parameters:flightNo , Model model
	 * Description:This method is invoked when the user clicks book seats button 
	 * in ARS_Customer_SearchFlightList.jsp
	 * It checks for seat availability
	 * Blocks the seats if available
	 * This method loads the passenger form
	 * @author Nikhil Pereira
	 ***********************************************************************************/
	@RequestMapping(value = "processBookSeats")
	String processBookSeats(@RequestParam("flightNo") String flightNo,
			Model model, HttpServletRequest request){

		HttpSession session = request.getSession();
		FlightInfoDTO findFlightInfoDTO = (FlightInfoDTO) session.getAttribute("findFlightInfoDTO");
		try {
			if(arsService.checkSeatAvailability(new Integer(flightNo), 
					findFlightInfoDTO.getClassType(), findFlightInfoDTO.getNumPassengers())){

				List<SeatInfoDTO> seatInfoList = new ArrayList<SeatInfoDTO>();
				System.out.println("cont blockSeats");
				int numBlockedSeats = arsService.blockSeats(seatInfoList,new Integer(flightNo),
				findFlightInfoDTO.getClassType(), findFlightInfoDTO.getNumPassengers());
				System.out.println("cont blockSeats");
				session.setAttribute("seatInfoList", seatInfoList);
				FlightInfoDTO flightInfoDTO = arsService.getFlightInfo(new Integer(flightNo));
				System.out.println("cont getFlightInfo");
				flightInfoDTO.setNumPassengers(findFlightInfoDTO.getNumPassengers());
				flightInfoDTO.setClassType(findFlightInfoDTO.getClassType());
				session.setAttribute("flightInfoDTO", flightInfoDTO);

				double totalFare = arsService.getTotalFare(flightInfoDTO.getNumPassengers(), 
						new Integer(flightInfoDTO.getFlightNo().toString()), flightInfoDTO.getClassType());
				System.out.println("cont getTotalFare");
				session.setAttribute("totalFare", totalFare);
			}
			else{
				model.addAttribute("error", "Seats are unavailable for flight with flightNo: "+flightNo);
				return "ARS_All_Error";
			}

		}
		catch (DataAccessException exception){
			model.addAttribute("error", "ARS Data Access Issues due to : "+exception);
			return "ARS_All_Error";
		}
		model.addAttribute("passengerDTO", new PassengerDTO());
		return "ARS_Customer_PassengerForm";
	}


	/**********************************************************************************
	 * Method Name: String processPassengerForm(Model model)
	 * Return type:String
	 * Parameters: Model model
	 * Description:This method is invoked when the user clicks book seats button 
	 * in ARS_Customer_SearchFlightForm.jsp
	 * This method loads the passenger form if there are passenger details left to enter
	 * else it loads the credit card form
	 * @author Nikhil Pereira
	 ***********************************************************************************/

	@RequestMapping(value = "processPassengerForm")
	String processPassengerForm(@ModelAttribute("passengerDTO") @Valid 
			PassengerDTO passengerDTO, BindingResult result,
			Model model, HttpServletRequest request){

		if(result.hasErrors()){
			return "ARS_Customer_PassengerForm";
		}
		try{

			HttpSession session = request.getSession();

			Integer counter = (Integer) session.getAttribute("counter");

			if(counter == null){
				counter = new Integer(1);
			}
			List<PassengerDTO> passengerList = (List<PassengerDTO>) session.getAttribute("passengerList");
			FlightInfoDTO findFlightInfoDTO = (FlightInfoDTO) session.getAttribute("findFlightInfoDTO");
			if( passengerList == null){
				passengerList = new ArrayList<PassengerDTO>();
			}
			passengerList.add(passengerDTO);
			session.setAttribute("passengerList", passengerList);

			if(counter < findFlightInfoDTO.getNumPassengers()){
				counter++;

				session.setAttribute("counter", counter);
				model.addAttribute("passengerDTO", new PassengerDTO());

				return "ARS_Customer_PassengerForm";
			}
			else{

				model.addAttribute("creditCardDTO", new CreditCardDTO());
				return "ARS_Customer_CreditCardForm";
			}
		}
		catch (DataAccessException exception){
			model.addAttribute("error", "ARS Data Access Issues due to : "+exception);
			return "ARS_All_Error";
		}
	}


	/**********************************************************************************
	 * Method Name: String processCreditCardForm(Model model)
	 * Return type:String
	 * Parameters: Model model
	 * Description:This method is invoked when the user clicks add passengers button 
	 * in ARS_Customer_PassengerForm.jsp
	 * This method generates the ticket 
	 * @author Nikhil Pereira
	 ***********************************************************************************/

	@RequestMapping(value = "processCreditCardForm")
	String processCreditCardForm(@ModelAttribute("creditCardDTO") 
	CreditCardDTO creditCardDTO, BindingResult result,
	Model model, HttpServletRequest request){


		if(result.hasErrors()){
			return "ARS_Customer_CreditCardForm";
		}
		try{
			HttpSession session = request.getSession();
			String userId = (String) session.getAttribute("userId");
			List<PassengerDTO> passengerList = (List<PassengerDTO>) session.getAttribute("passengerList");
			FlightInfoDTO flightInfoDTO = (FlightInfoDTO) session.getAttribute("flightInfoDTO");
			List<SeatInfoDTO> seatInfoList = (List<SeatInfoDTO>) session.getAttribute("seatInfoList");
			BookingInfoDTO bookingInfoDTO = new BookingInfoDTO();
			System.out.println(flightInfoDTO.toString());
			if(arsService.bookSeatsTransaction(passengerList, 
					flightInfoDTO, seatInfoList,bookingInfoDTO, userId)){

				session.setAttribute("passengerList", passengerList);
				session.setAttribute("flightInfoDTO", flightInfoDTO);
				session.setAttribute("seatInfoList", seatInfoList);
				System.out.println(bookingInfoDTO);
				session.setAttribute("bookingInfoDTO", bookingInfoDTO);
			}
		}
		catch (DataAccessException exception){
			model.addAttribute("error", "Could not complete booking transaction. ARS Data Access Issues due to : "+exception);
			return "ARS_All_Error";
		}
		return "ARS_Customer_Ticket";
	}

	//-------------------------------------------------------------
	// 						EXECUTIVE
	//-------------------------------------------------------------


	/**********************************************************************************
	 * Method Name: String loadFlightOccupancyForm(Model model)
	 * Return type:String
	 * Parameters: Model model
	 * Description:This method is invoked when the user clicks add passengers button 
	 * in ARS_Customer_PassengerForm.jsp
	 * This method generates the ticket 
	 * @author Nikhil Pereira
	 ***********************************************************************************/

	@RequestMapping(value = "loadFlightOccupancyForm")
	String loadFlightOccupancyForm(Model model){
		model.addAttribute("flightInfoDTO", new FlightInfoDTO());
		return "ARS_Executive_FlightOccupancyForm";
	}

	/**********************************************************************************
	 * Method Name: String processFlightOccupancyForm(Model model)
	 * Return type:String
	 * Parameters: Model model
	 * Description:This method is invoked when the user clicks add passengers button 
	 * in ARS_Customer_PassengerForm.jsp
	 * This method generates the ticket 
	 * @author Nikhil Pereira
	 ***********************************************************************************/

	@RequestMapping(value = "processFlightOccupancyForm")
	String processFlightOccupancyForm(@ModelAttribute("flightInfoDTO") //@Valid
	FlightInfoDTO flightInfoDTO, BindingResult result,
	Model model, HttpServletRequest request){

		/*if(result.getFieldError("departureDate") == null){
			model.addAttribute("departuredateError","Departure Date cannot be empty");
			return "ARS_Executive_FlightOccupancyForm";
		}
		if(result.getFieldError("classType") == null){
			model.addAttribute("classTypeError","classType cannot be empty");
			return "ARS_Executive_FlightOccupancyForm";
		}*/
		HttpSession session = request.getSession();
		session.setAttribute("classType", flightInfoDTO.getClassType());
		List<FlightInfoDTO> flightList = null;
		try {
			flightList = arsService.getFlightInfoList(flightInfoDTO.getDepartureDate());
		} 
		catch (DataAccessException exception){
			model.addAttribute("error",exception);
			return "ARS_All_Error";
		}
		model.addAttribute("flightList", flightList);
		return "ARS_Executive_FlightOccupancyForm";
	}

	/**********************************************************************************
	 * Method Name: String processViewFlightOccupancy(Model model)
	 * Return type:String
	 * Parameters: Model model
	 * Description:This method is invoked when the user clicks add passengers button 
	 * in ARS_Customer_PassengerForm.jsp
	 * This method generates the ticket 
	 * @author Nikhil Pereira
	 ***********************************************************************************/

	@RequestMapping(value = "processViewFlightOccupancy")
	String processViewFlightOccupancy(@RequestParam("flightNo") String flightNo,
			Model model, HttpServletRequest request){

		HttpSession session = request.getSession();
		String classType = (String) session.getAttribute("classType");
		FlightInfoDTO flightInfoDTO = arsService.getFlightInfo(new Integer(flightNo));
		int availableSeats = arsService.getAvailableSeats(new Integer(flightNo), classType);
		model.addAttribute("availableSeats",availableSeats);
		if("firstClass".equals(classType)){
			model.addAttribute("bookedSeats", flightInfoDTO.getFirstSeats()-availableSeats);
			model.addAttribute("totalSeats", flightInfoDTO.getFirstSeats());
		}
		else if("businessClass".equals(classType)){
			model.addAttribute("bookedSeats", flightInfoDTO.getBusinessSeats()-availableSeats);
			model.addAttribute("totalSeats", flightInfoDTO.getBusinessSeats());
		}
		return "ARS_Executive_ViewFlightOccupancy";
	}
}


