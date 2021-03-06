package com.dac.onlineparking.module.user;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "mvc/cityArea", method = RequestMethod.GET)
	public @ResponseBody List<CityAreaVO> selectCityArea(HttpServletRequest request,
			@RequestParam("cityId") int areaId) {
		return userService.selectCityArea(areaId);
	}

	@RequestMapping(value = "mvc/areaSlot", method = RequestMethod.GET)
	public @ResponseBody List<UserBookSlotVO> getAreaSlot(HttpServletRequest request,
			@RequestParam("areaId") int areaId) {
		return userService.getAreaSlot(areaId);
	}

	@RequestMapping(value = "mvc/slotBookingUsingWallet", method = RequestMethod.POST)
	public @ResponseBody boolean slotBookUsingWolet(HttpServletRequest request, @RequestBody WolletBookVO bookVO)
			throws SQLException {
		return userService.slotBookUsingWolet(bookVO);
	}

	@RequestMapping(value = "mvc/walletMoney", method = RequestMethod.GET)
	public @ResponseBody WalletMoneyVO walletMoney(HttpServletRequest request, @RequestParam("userId") int userId)
			throws SQLException {
		return userService.walletMoney(userId);
	}
}
