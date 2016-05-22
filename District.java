package War_Game;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class District {
	private int[] coordinates;
	private String name;
	private Nation occupied, belongsTo;
	private boolean hasMajorCity;
	private boolean hasMajorIndustry, hasAirfield;

	/**
	 * Constructs a District object
	 * 
	 * @param regional
	 *            - region name
	 */
	public District(String regional) {
		// need to make methods that decide if it has a city, industry, or
		// airfield, t
		name = regional;
		// occupied = occupation;
		coordinates = getCoordinates();
		// hasMajorCity = bigCity;
		// hasMajorIndustry = industry;
	}
	
	public String toString()
	{
		return "{"+getX()+","+getY()+"}";
	}

	/**
	 * Changes the occupation of the district once conquered, all infrastructure
	 * is destroyed
	 * 
	 * @param nation
	 *            - the nation that conquers the district
	 */
	protected void capture(Nation occupant) {
		occupied = occupant;
		hasMajorIndustry = false;
		hasAirfield = false;
	}

	
	protected Troop getTroop()
	{
		ArrayList<Troop> ref = occupied.getTroops();
		for (Troop t : ref) {
			if (t.getDistrict().equals(this))
				return t;
		}
		return null;
	}
	
	protected String getStatus()
	{
		String s = "";
		if(hasMajorCity())
			s += "This district has a large city ";
		if(hasMajorIndustry())
			s += ",industry ";
		if(hasAirfield())
			s += ",airfield ";
		else if (!(hasAirfield() || hasMajorIndustry() || hasMajorCity()))
			s = "this city has no infrastructure";
		return s;
	}
	
	/**
	 * sets distict occupied
	 * 
	 * @param occupant
	 *            a nation that controls the district
	 */
	protected void setOccupiedBy(Nation occupant) {
		occupied = occupant;
	}

	public boolean isOccupied() {
		ArrayList<Troop> ref = occupied.getTroops();
		for (Troop t : ref) {
			if (t.getDistrict().getName().equals(name))
				return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return coordinates[0];
	}

	public int getY() {
		return coordinates[1];
	}

	/**
	 * this method is really long since there are a TON of districts
	 * 
	 * @return coordinates
	 */
	public int[] getCoordinates() {
		switch (name) {
		case "Delhi":
			return new int[] { 240, 500 };
		case "Haryana":
			return new int[] { 227, 483 };
		case "Bathinda":
			return new int[] { 213, 464 };
		case "Amritsar":
			return new int[] { 216, 443 };
		case "Jammu":
			return new int[] { 210, 405 };
		case "Kashmir Valley":
			return new int[] { 205, 365 };
		case "Ladakh":
			return new int[] { 250, 400 };
		case "Aksai Chin":
			return new int[] { 273, 377 };
		case "Himachal":
			return new int[] { 245, 435 };
		case "Uttrakhand":
			return new int[] { 277, 447 };
		case "Derhadun":
			return new int[] { 275, 470 };
		case "Agra":
			return new int[] { 265, 520 };
		case "Kanpur":
			return new int[] { 280, 540 };
		case "Allahabad":
			return new int[] { 310, 550 };
		case "Jaipur":
			return new int[] { 230, 520 };
		case "Ajmer":
			return new int[] { 200, 540 };
		case "Jodhpur":
			return new int[] { 170, 540 };
		case "Ahmedabad":
			return new int[] { 170, 595 };
		case "Rann of Kutch":
			return new int[] { 130, 580 };
		case "Rajkot":
			return new int[] { 150, 600 };
		case "Vadodara":
			return new int[] { 185, 610 };
		case "Surat":
			return new int[] { 176, 640 };
		case "Mumbai":
			return new int[] { 180, 665 };
		case "Godhra":
			return new int[] { 215, 595 };
		case "Bhopal":
			return new int[] { 250, 590 };
		case "Jalagaon":
			return new int[] { 200, 630 };
		case "Aurangabad":
			return new int[] { 200, 660 };
		case "Poona":
			return new int[] { 195, 689 };
		case "Goa":
			return new int[] { 195, 719 };
		case "Mangalore":
			return new int[] { 210, 760 };
		case "Kochi":
			return new int[] { 232, 814 };
		case "Thiruvananthapuram":
			return new int[] { 239, 832 };
		case "Madurai":
			return new int[] { 254, 810 };
		case "Tirucirappali":
			return new int[] { 270, 795 };
		case "Puducherry":
			return new int[] { 281, 776 };
		case "Tirvannamalai":
			return new int[] { 270, 757 };
		case "Chennai":
			return new int[] { 284, 728 };
		case "Ongole":
			return new int[] { 302, 703 };
		case "Vishakapatnam":
			return new int[] { 337, 666 };
		case "Cuttack":
			return new int[] { 389, 627 };
		case "Rourkela":
			return new int[] { 371, 612 };
		case "Kolkatta":
			return new int[] { 414, 600 };
		case "Asansol":
			return new int[] { 403, 585 };
		case "Silliguri":
			return new int[] { 415, 533 };
		case "Sikkim":
			return new int[] { 421, 512 };
		case "Guwahati":
			return new int[] { 471, 536 };
		case "Tezpur":
			return new int[] { 516, 521 };
		case "Arunachal Pradesh":
			return new int[] { 519, 499 };
		case "Imphal":
			return new int[] { 506, 552 };
		case "Mizoram":
			return new int[] { 506, 552 };
		case "Muzaffarpur":
			return new int[] { 368, 536 };
		case "Patna":
			return new int[] { 340, 531 };
		case "Gaya":
			return new int[] { 335, 556 };
		case "Ranchi":
			return new int[] { 358, 566 };
		case "Jamshedpur":
			return new int[] { 367, 593 };
		case "Sitapur":
			return new int[] { 337, 592 };
		case "Bliaspur":
			return new int[] { 320, 602 };
		case "Raipur":
			return new int[] { 319, 624 };
		case "Jagdalpur":
			return new int[] { 309, 656 };
		case "Jaisalmer":
			return new int[] { 146, 518 };
		case "Palanpur":
			return new int[] { 162, 573 };
		case "Hubli":
			return new int[] { 209, 718 };
		case "Bangalore":
			return new int[] { 225, 741 };
		case "Kozhikode":
			return new int[] { 225, 784 };
		case "Tirupati":
			return new int[] { 252, 753 };
		case "Cuddupa":
			return new int[] { 259, 727 };
		case "Gulbarga":
			return new int[] { 238, 688 };
		case "Mysore":
			return new int[] { 232, 767 };
		case "Hyderabad":
			return new int[] { 261, 689 };
		case "Vijayapura":
			return new int[] { 219, 691 };
		case "Solapur":
			return new int[] { 225, 652 };
		case "Nanded":
			return new int[] { 249, 605 };
		case "Suryapet":
			return new int[] { 286, 686 };
		case "Nagpur":
			return new int[] { 247, 630 };
		case "Chandrapur":
			return new int[] { 277, 629 };
		case "Jhansi":
			return new int[] { 281, 560 };
		case "Rewa":
			return new int[] { 281, 560 };
		case "Jabalpur":
			return new int[] { 285, 590 };
		case "Gwalior":
			return new int[] { 252, 547 };
		case "Merut":
			return new int[] { 261, 489 };
		case "Lucknow":
			return new int[] { 297, 522 };
		case "Faziabad":
			return new int[] { 319, 536 };
		case "Bikaner":
			return new int[] { 193, 487 };
		case "Combiatore":
			return new int[] { 254, 781 };
		case "Kota":
			return new int[] { 208, 552 };
		case "Bhagalpur":
			return new int[] { 397, 556 };
		case "Tripura":
			return new int[] { 482, 575 };
		case "Nizamabad":
			return new int[] { 272, 657 };
		case "Balangir":
			return new int[] { 341, 627 };
		case "Ganghinagar":
			return new int[] { 195, 592 };
		/*
		 * Chinese Districts here
		 */
		case "Beijing":
			return new int[] { 842, 331 };
		case "Tianjin":
			return new int[] { 858, 329 };
		case "Canzhou":
			return new int[] { 886, 339 };
		case "Yantai":
			return new int[] { 925, 341 };
		case "Qingdao":
			return new int[] { 897, 367 };
		case "Liyanyangang":
			return new int[] { 892, 390 };
		case "Yancheng":
			return new int[] { 905, 414 };
		case "Nantong":
			return new int[] { 923, 433 };
		case "Shanghai":
			return new int[] { 927, 450 };
		case "Suzhou":
			return new int[] { 893, 435 };
		case "Hangzhou":
			return new int[] { 894, 454 };
		case "Jinhua":
			return new int[] { 908, 476 };
		case "Zhoushan":
			return new int[] { 933, 474 };
		case "Taizhou":
			return new int[] { 927, 489 };
		case "Wenzhou":
			return new int[] { 900, 527 };
		case "Ningde":
			return new int[] { 886, 551 };
		case "Fuzhou":
			return new int[] { 873, 568 };
		case "Putian":
			return new int[] { 853, 575 };
		case "Xiamen":
			return new int[] { 831, 587 };
		case "Hong Kong":
			return new int[] { 818, 600 };
		case "Macau":
			return new int[] { 801, 604 };
		case "Guangzhou":
			return new int[] { 800, 590 };
		case "Zhanjiang":
			return new int[] { 757, 613 };
		case "Hainan Dao":
			return new int[] { 751, 656 };
		case "Guigang":
			return new int[] { 763, 576 };
		case "Wuzhou":
			return new int[] { 809, 563 };
		case "Chenzhou":
			return new int[] { 837, 544 };
		case "Longyan":
			return new int[] { 865, 541 };
		case "Sanming":
			return new int[] { 880, 507 };
		case "Quzhou":
			return new int[] { 865, 475 };
		case "Huangshan":
			return new int[] { 836, 494 };
		case "Jiulong":
			return new int[] { 834, 517 };
		case "Changde":
			return new int[] { 759, 505 };
		case "Yichang":
			return new int[] { 759, 462 };
		case "Yueyang":
			return new int[] { 791, 462 };
		case "Huaihua":
			return new int[] { 719, 478 };
		case "Hechi":
			return new int[] { 680, 530 };
		case "Nanning":
			return new int[] { 709, 579 };
		case "Wenshan":
			return new int[] { 641, 582 };
		case "Dali":
			return new int[] { 600, 550 };
		case "Nyingchi":
			return new int[] { 533, 482 };
		case "Lhasa":
			return new int[] { 420, 467 };
		case "Ngari":
			return new int[] { 315, 439 };
		case "Gerze":
			return new int[] { 374, 400 };
		case "Kashgar":
			return new int[] { 249, 313 };
		case "Aksu":
			return new int[] { 303, 265 };
		case "Yili":
			return new int[] { 325, 216 };
		case "Karamay":
			return new int[] { 406, 158 };
		case "Kumul":
			return new int[] { 496, 233 };
		case "Jiuquan":
			return new int[] { 549, 297 };
		case "Haixi":
			return new int[] { 650, 350 };
		case "Xining":
			return new int[] { 738, 346 };
		case "Xian":
			return new int[] { 779, 356 };
		case "Wuhan":
			return new int[] { 787, 465 };
		case "Zhuzhou":
			return new int[] { 790, 500 };
		case "Yichun":
			return new int[] { 827, 461 };
		case "Nanjing":
			return new int[] { 835, 424 };
		case "Heifei":
			return new int[] { 785, 433 };
		case "Huainan":
			return new int[] { 796, 409 };
		case "Bengbu":
			return new int[] { 784, 393 };
		case "Xuzhou":
			return new int[] { 812, 358 };
		case "Bayingol":
			return new int[] { 327, 329 };
		case "Urumqi":
			return new int[] { 399, 246 };
		case "Ruoqiang":
			return new int[] { 406, 314 };
		case "Dulan":
			return new int[] { 512, 334 };
		case "Zekog":
			return new int[] { 597, 360 };
		case "Gangu":
			return new int[] { 669, 389 };
		case "Chongxin":
			return new int[] { 736, 392 };
		case "Chenggu":
			return new int[] { 721, 418 };
		case "Qingchuan":
			return new int[] { 700, 450 };
		case "Chengdu":
			return new int[] { 671, 462 };
		case "Muli":
			return new int[] { 609, 460 };
		case "Lhari":
			return new int[] { 505, 452 };
		case "Qumarleb":
			return new int[] { 500, 400 };
		case "Alxa":
			return new int[] { 658, 284 };
		case "Datong":
			return new int[] { 750, 300 };
		case "Fengzhen":
			return new int[] { 810, 295 };
		case "Chengde":
			return new int[] { 841, 267 };
		case "Xilin Gol":
			return new int[] { 840, 210 };
		case "Shenyang":
			return new int[] { 970, 260 };
		case "Changchun":
			return new int[] { 1010, 225 };
		case "Mudanjiang":
			return new int[] { 1070, 192 };
		case "Da Hinggan Ling":
			return new int[] { 970, 50 };
		case "Hulun Buir":
			return new int[] { 900, 120 };
		case "Baoji":
			return new int[] { 705, 361 };
		case "Kunming":
			return new int[] { 646, 544 };
		case "Chongquing":
			return new int[] { 654, 492 };
		case "Changsha":
			return new int[] { 718, 510 };
		case "Chaoyang":
			return new int[] { 909, 254 };
		case "Harbin":
			return new int[] { 950, 190 };
		case "Suihua":
			return new int[] { 994, 135 };
		/*
		 * Mongolian Districts
		 */
		case "Hovd":
			return new int[] { 480, 160 };
		case "Uvs":
			return new int[] { 525, 125 };
		case "Govi-Altai":
			return new int[] { 580, 190 };
		case "Hovsgol":
			return new int[] { 500, 100 };
		case "Selenge":
			return new int[] { 685, 120 };
		case "South Govi":
			return new int[] { 665, 235 };
		case "East Govi":
			return new int[] { 750, 190 };
		case "Dornod":
			return new int[] { 800, 150 };
		case "Marun":
			return new int[] { 606, 106 };
		/*
		 * North Korea
		 */
		case "Changang-Do":
			return new int[] { 1000, 285 };
		case "Yanggan-Do":
			return new int[] { 1045, 270 };
		case "Hamgyong-Bukto":
			return new int[] { 1060, 255 };
		case "PiYongang Namdo":
			return new int[] { 1005, 305 };
		case "Pyongyang":
			return new int[] { 1005, 315 };
		case "Kangwon-Do":
			return new int[] { 1020, 320 };
		case "Kimchaek":
			return new int[] { 1026, 290 };
		case "Hamhung":
			return new int[] { 1030, 310 };
		/**
		 * South Korea
		 */
		case "Incheon":
			return new int[] { 1018, 338 };
		case "Seoul":
			return new int[] { 1025, 335 };
		case "Gangwon":
			return new int[] { 1035, 330 };
		case "Mitan-myeon":
			return new int[] { 1050, 343 };
		case "Andong":
			return new int[] { 1053, 358 };
		case "Busan":
			return new int[] { 1043, 375 };
		case "Gwangju":
			return new int[] { 1020, 380 };
		case "Daegu":
			return new int[] { 1045, 367 };
		case "Daejon":
			return new int[] { 1027, 356 };
		default:
			return null;
		/**
		 * Pakistan
		 */
		case "Peshawar":
			return new int[] { 165, 375 };
		case "Islamabad":
			return new int[] { 178, 415 };
		case "Rawalpindi":
			return new int[] { 192, 432 };
		case "Lahore":
			return new int[] { 192, 432 };
		case "Bahawalpur":
			return new int[] { 185, 454 };
		case "Kharipur":
			return new int[] { 113, 512 };
		case "Nawabshah":
			return new int[] { 116, 552 };
		case "Karachi":
			return new int[] { 76, 545 };
		case "Hyderbad":
			return new int[] { 96, 562 };
		case "Balochistan":
			return new int[] { 70, 511 };
		case "Quetta":
			return new int[] { 110, 450 };
		case "Khyber":
			return new int[] { 140, 414 };
		case "Multan":
			return new int[] { 145, 471 };
		case "Faisalabad":
			return new int[] { 159, 436 };
		/**
		 * Nepal
		 */
		case "Patan":
			return new int[] { 299, 480 };
		case "Jayapritvi":
			return new int[] { 320, 490 };
		case "Kankri":
			return new int[] { 342, 501 };
		case "Kathmandu":
			return new int[] { 381, 516 };
		case "Dharan":
			return new int[] { 402, 516 };
		case "Dhamak":
			return new int[] { 410, 530 };
		/**
		 * Bhutan
		 */
		case "Thimphu":
			return new int[] { 450, 516 };
		/**
		 * Bangladesh
		 */
		case "Rajshahi":
			return new int[] { 430, 565 };
		case "Habiganj":
			return new int[] { 463, 563 };
		case "Dhaka":
			return new int[] { 458, 586 };
		case "Khulna":
			return new int[] { 437, 596 };
		case "Chittagong":
			return new int[] { 476, 605 };
		/**
		 * Sri Lanka
		 */
		case "Kandy":
			return new int[] { 301, 857 };
		case "Colombo":
			return new int[] { 287, 845 };
		case "Arunadhapura":
			return new int[] { 292, 828 };
		case "Batticaloa":
			return new int[] { 311, 847 };
		/**
		 * Afghanistan
		 */
		case "Jalalabad":
			return new int[] { 140, 380 };
		case "Kabul":
			return new int[] { 116, 380 };
		case "Kunduz":
			return new int[] { 131, 350 };
		case "Mazar-e-Shariff":
			return new int[] { 70, 360 };
		case "Herat":
			return new int[] { 15, 390 };
		case "Pasaband":
			return new int[] { 70, 400 };
		case "Lashkargah":
			return new int[] { 60, 455 };
		}
	}

	/**
	 * checks if the district has a major city
	 * 
	 * @return true if the district has a major city
	 */
	public boolean hasMajorCity() {
		switch (name) {
		case "Delhi":
			return true;
		case "Haryana":
			return true;
		case "Bathinda":
			return false;
		case "Amritsar":
			return true;
		case "Jammu":
			return true;
		case "Kashmir Valley":
			return false;
		case "Ladakh":
			return false;
		case "Aksai Chin":
			return false;
		case "Himachal":
			return true;
		case "Uttrakhand":
			return false;
		case "Derhadun":
			return true;
		case "Agra":
			return true;
		case "Kanpur":
			return true;
		case "Allahabad":
			return true;
		case "Jaipur":
			return true;
		case "Ajmer":
			return false;
		case "Jodhpur":
			return false;
		case "Ahmedabad":
			return true;
		case "Rann of Kutch":
			return false;
		case "Rajkot":
			return false;
		// but wait, there's more!
		case "Vadodara":
			return true;
		case "Surat":
			return true;
		case "Mumbai":
			return true;
		case "Godhra":
			return false;
		case "Bhopal":
			return true;
		case "Jalagaon":
			return false;
		case "Aurangabad":
			return false;
		case "Poona":
			return true;
		case "Goa":
			return true;
		case "Mangalore":
			return false;
		case "Kochi":
			return true;
		case "Thiruvananthapuram":
			return true;
		case "Madurai":
			return true;
		case "Tirucirappali":
			return false;
		case "Puducherry":
			return false;
		case "Tirvannamalai":
			return false;
		case "Chennai":
			return true;
		case "Ongole":
			return false;
		case "Vishakapatnam":
			return false;
		case "Cuttack":
			return false;
		case "Rourkela":
			return false;
		case "Kolkatta":
			return true;
		case "Asansol":
			return false;
		case "Silliguri":
			return false;
		case "Sikkim":
			return true;
		case "Guwahati":
			return true;
		case "Tezpur":
			return false;
		case "Arunachal Pradesh":
			return false;
		case "Imphal":
			return false;
		case "Mizoram":
			return false;
		case "Muzaffarpur":
			return false;
		case "Patna":
			return true;
		case "Gaya":
			return true;
		case "Ranchi":
			return true;
		case "Jamshedpur":
			return true;
		case "Sitapur":
			return false;
		case "Bliaspur":
			return false;
		case "Raipur":
			return true;
		case "Jagdalpur":
			return false;
		case "Jaisalmer":
			return false;
		case "Palanpur":
			return false;
		case "Hubli":
			return true;
		case "Bangalore":
			return true;
		case "Kozhikode":
			return false;
		case "Tirupati":
			return false;
		case "Cuddupa":
			return false;
		case "Gulbarga":
			return false;
		case "Mysore":
			return false;
		case "Hyderabad":
			return true;
		case "Vijayapura":
			return false;
		case "Solapur":
			return false;
		case "Nanded":
			return false;
		case "Suryapet":
			return false;
		case "Nagpur":
			return true;
		case "Chandrapur":
			return false;
		case "Jhansi":
			return true;
		case "Rewa":
			return false;
		case "Jabalpur":
			return false;
		case "Gwalior":
			return true;
		case "Merut":
			return false;
		case "Lucknow":
			return false;
		case "Faziabad":
			return false;
		case "Bikaner":
			return false;
		case "Combiatore":
			return false;
		case "Kota":
			return true;
		case "Bhagalpur":
			return true;
		case "Tripura":
			return false;
		case "Nizamabad":
			return false;
		case "Balangir":
			return false;
		case "Ganghinagar":
			return true;
		/*
		 * Chinese Districts here
		 */
		case "Beijing":
			return true;
		case "Tianjin":
			return true;
		case "Canzhou":
			return false;
		case "Yantai":
			return false;
		case "Qingdao":
			return true;
		case "Liyanyangang":
			return true;
		case "Yancheng":
			return false;
		case "Nantong":
			return true;
		case "Shanghai":
			return true;
		case "Suzhou":
			return true;
		case "Hangzhou":
			return false;
		case "Jinhua":
			return false;
		case "Zhoushan":
			return false;
		case "Taizhou":
			return false;
		case "Wenzhou":
			return true;
		case "Ningde":
			return false;
		case "Fuzhou":
			return true;
		case "Putian":
			return false;
		case "Xiamen":
			return true;
		case "Hong Kong":
			return true;
		case "Macau":
			return true;
		case "Guangzhou":
			return true;
		case "Zhanjiang":
			return false;
		case "Hainan Dao":
			return true;
		case "Guigang":
			return false;
		case "Wuzhou":
			return true;
		case "Chenzhou":
			return true;
		case "Longyan":
			return false;
		case "Sanming":
			return false;
		case "Quzhou":
			return false;
		case "Huangshan":
			return false;
		case "Jiulong":
			return false;
		case "Changde":
			return true;
		case "Yichang":
			return false;
		case "Yueyang":
			return false;
		case "Huaihua":
			return false;
		case "Hechi":
			return false;
		case "Nanning":
			return false;
		case "Wenshan":
			return true;
		case "Dali":
			return true;
		case "Nyingchi":
			return false;
		case "Lhasa":
			return true;
		case "Ngari":
			return false;
		case "Gerze":
			return false;
		case "Kashgar":
			return false;
		case "Aksu":
			return false;
		case "Yili":
			return false;
		case "Karamay":
			return false;
		case "Kumul":
			return false;
		case "Jiuquan":
			return false;
		case "Haixi":
			return false;
		case "Xining":
			return false;
		case "Xian":
			return true;
		case "Wuhan":
			return true;
		case "Zhuzhou":
			return false;
		case "Yichun":
			return false;
		case "Nanjing":
			return false;
		case "Heifei":
			return false;
		case "Huainan":
			return false;
		case "Bengbu":
			return false;
		case "Xuzhou":
			return true;
		case "Bayingol":
			return false;
		case "Urumqi":
			return false;
		case "Ruoqiang":
			return false;
		case "Dulan":
			return false;
		case "Zekog":
			return false;
		case "Gangu":
			return false;
		case "Chongxin":
			return false;
		case "Chenggu":
			return false;
		case "Qingchuan":
			return false;
		case "Chengdu":
			return true;
		case "Muli":
			return false;
		case "Lhari":
			return false;
		case "Qumarleb":
			return false;
		case "Alxa":
			return false;
		case "Datong":
			return false;
		case "Fengzhen":
			return true;
		case "Chengde":
			return true;
		case "Xilin Gol":
			return false;
		case "Shenyang":
			return true;
		case "Changchun":
			return true;
		case "Mudanjiang":
			return false;
		case "Da Hinggan Ling":
			return false;
		case "Hulun Buir":
			return false;
		case "Baoji":
			return false;
		case "Kunming":
			return true;
		case "Chongquing":
			return true;
		case "Changsha":
			return true;
		case "Chaoyang":
			return false;
		case "Harbin":
			return true;
		case "Suihua":
			return false;
		/*
		 * Mongolian Districts
		 */
		case "Hovd":
			return false;
		case "Uvs":
			return false;
		case "Govi-Altai":
			return false;
		case "Hovsgol":
			return true;
		case "Selenge":
			return false;
		case "South Govi":
			return false;
		case "East Govi":
			return false;
		case "Dornod":
			return false;
		case "Marun":
			return true;
		/*
		 * North Korea
		 */
		case "Changang-Do":
			return false;
		case "Yanggan-Do":
			return true;
		case "Hamgyong-Bukto":
			return false;
		case "PiYongang Namdo":
			return false;
		case "Pyongyang":
			return true;
		case "Kangwon-Do":
			return false;
		case "Kimchaek":
			return false;
		case "Hamhung":
			return false;
		/**
		 * South Korea
		 */
		case "Incheon":
			return true;
		case "Seoul":
			return true;
		case "Gangwon":
			return true;
		case "Mitan-myeon":
			return false;
		case "Andong":
			return false;
		case "Busan":
			return true;
		case "Gwangju":
			return false;
		case "Daegu":
			return false;
		case "Daejon":
			return true;
		default:
			return false;
		}
	}

	/**
	 * checks if the district has a major industrial area
	 * 
	 * @return true if there region has major industry
	 */
	public boolean hasMajorIndustry() {
		switch (name) {
		case "Delhi":
			return true;
		case "Haryana":
			return true;
		case "Bathinda":
			return false;
		case "Amritsar":
			return true;
		case "Jammu":
			return true;
		case "Kashmir Valley":
			return false;
		case "Ladakh":
			return false;
		case "Aksai Chin":
			return false;
		case "Himachal":
			return true;
		case "Uttrakhand":
			return false;
		case "Derhadun":
			return true;
		case "Agra":
			return true;
		case "Kanpur":
			return true;
		case "Allahabad":
			return true;
		case "Jaipur":
			return true;
		case "Ajmer":
			return false;
		case "Jodhpur":
			return false;
		case "Ahmedabad":
			return true;
		case "Rann of Kutch":
			return false;
		case "Rajkot":
			return false;
		// but wait, there's more!
		case "Vadodara":
			return true;
		case "Surat":
			return true;
		case "Mumbai":
			return true;
		case "Godhra":
			return false;
		case "Bhopal":
			return true;
		case "Jalagaon":
			return false;
		case "Aurangabad":
			return false;
		case "Poona":
			return true;
		case "Goa":
			return true;
		case "Mangalore":
			return false;
		case "Kochi":
			return true;
		case "Thiruvananthapuram":
			return true;
		case "Madurai":
			return true;
		case "Tirucirappali":
			return false;
		case "Puducherry":
			return false;
		case "Tirvannamalai":
			return false;
		case "Chennai":
			return true;
		case "Ongole":
			return false;
		case "Vishakapatnam":
			return false;
		case "Cuttack":
			return false;
		case "Rourkela":
			return false;
		case "Kolkatta":
			return true;
		case "Asansol":
			return false;
		case "Silliguri":
			return false;
		case "Sikkim":
			return true;
		case "Guwahati":
			return true;
		case "Tezpur":
			return false;
		case "Arunachal Pradesh":
			return false;
		case "Imphal":
			return false;
		case "Mizoram":
			return false;
		case "Muzaffarpur":
			return false;
		case "Patna":
			return true;
		case "Gaya":
			return true;
		case "Ranchi":
			return true;
		case "Jamshedpur":
			return true;
		case "Sitapur":
			return false;
		case "Bliaspur":
			return false;
		case "Raipur":
			return true;
		case "Jagdalpur":
			return false;
		case "Jaisalmer":
			return false;
		case "Palanpur":
			return false;
		case "Hubli":
			return true;
		case "Bangalore":
			return true;
		case "Kozhikode":
			return false;
		case "Tirupati":
			return false;
		case "Cuddupa":
			return false;
		case "Gulbarga":
			return false;
		case "Mysore":
			return false;
		case "Hyderabad":
			return true;
		case "Vijayapura":
			return false;
		case "Solapur":
			return false;
		case "Nanded":
			return false;
		case "Suryapet":
			return false;
		case "Nagpur":
			return true;
		case "Chandrapur":
			return false;
		case "Jhansi":
			return true;
		case "Rewa":
			return false;
		case "Jabalpur":
			return false;
		case "Gwalior":
			return true;
		case "Merut":
			return false;
		case "Lucknow":
			return false;
		case "Faziabad":
			return false;
		case "Bikaner":
			return false;
		case "Combiatore":
			return false;
		case "Kota":
			return true;
		case "Bhagalpur":
			return true;
		case "Tripura":
			return false;
		case "Nizamabad":
			return false;
		case "Balangir":
			return false;
		case "Ganghinagar":
			return true;
		/*
		 * Chinese Districts here
		 */
		case "Beijing":
			return true;
		case "Tianjin":
			return true;
		case "Canzhou":
			return false;
		case "Yantai":
			return false;
		case "Qingdao":
			return true;
		case "Liyanyangang":
			return true;
		case "Yancheng":
			return false;
		case "Nantong":
			return true;
		case "Shanghai":
			return true;
		case "Suzhou":
			return true;
		case "Hangzhou":
			return false;
		case "Jinhua":
			return false;
		case "Zhoushan":
			return false;
		case "Taizhou":
			return false;
		case "Wenzhou":
			return true;
		case "Ningde":
			return false;
		case "Fuzhou":
			return true;
		case "Putian":
			return false;
		case "Xiamen":
			return true;
		case "Hong Kong":
			return true;
		case "Macau":
			return true;
		case "Guangzhou":
			return true;
		case "Zhanjiang":
			return false;
		case "Hainan Dao":
			return true;
		case "Guigang":
			return false;
		case "Wuzhou":
			return true;
		case "Chenzhou":
			return true;
		case "Longyan":
			return false;
		case "Sanming":
			return false;
		case "Quzhou":
			return false;
		case "Huangshan":
			return false;
		case "Jiulong":
			return false;
		case "Changde":
			return true;
		case "Yichang":
			return false;
		case "Yueyang":
			return false;
		case "Huaihua":
			return false;
		case "Hechi":
			return false;
		case "Nanning":
			return false;
		case "Wenshan":
			return true;
		case "Dali":
			return true;
		case "Nyingchi":
			return false;
		case "Lhasa":
			return true;
		case "Ngari":
			return false;
		case "Gerze":
			return false;
		case "Kashgar":
			return false;
		case "Aksu":
			return false;
		case "Yili":
			return false;
		case "Karamay":
			return false;
		case "Kumul":
			return false;
		case "Jiuquan":
			return false;
		case "Haixi":
			return false;
		case "Xining":
			return false;
		case "Xian":
			return true;
		case "Wuhan":
			return true;
		case "Zhuzhou":
			return false;
		case "Yichun":
			return false;
		case "Nanjing":
			return false;
		case "Heifei":
			return false;
		case "Huainan":
			return false;
		case "Bengbu":
			return false;
		case "Xuzhou":
			return true;
		case "Bayingol":
			return false;
		case "Urumqi":
			return false;
		case "Ruoqiang":
			return false;
		case "Dulan":
			return false;
		case "Zekog":
			return false;
		case "Gangu":
			return false;
		case "Chongxin":
			return false;
		case "Chenggu":
			return false;
		case "Qingchuan":
			return false;
		case "Chengdu":
			return true;
		case "Muli":
			return false;
		case "Lhari":
			return false;
		case "Qumarleb":
			return false;
		case "Alxa":
			return false;
		case "Datong":
			return false;
		case "Fengzhen":
			return true;
		case "Chengde":
			return true;
		case "Xilin Gol":
			return false;
		case "Shenyang":
			return true;
		case "Changchun":
			return true;
		case "Mudanjiang":
			return false;
		case "Da Hinggan Ling":
			return false;
		case "Hulun Buir":
			return false;
		case "Baoji":
			return false;
		case "Kunming":
			return true;
		case "Chongquing":
			return true;
		case "Changsha":
			return true;
		case "Chaoyang":
			return false;
		case "Harbin":
			return true;
		case "Suihua":
			return false;
		/*
		 * Mongolian Districts
		 */
		case "Hovd":
			return false;
		case "Uvs":
			return false;
		case "Govi-Altai":
			return false;
		case "Hovsgol":
			return true;
		case "Selenge":
			return false;
		case "South Govi":
			return false;
		case "East Govi":
			return false;
		case "Dornod":
			return false;
		case "Marun":
			return true;
		/*
		 * North Korea
		 */
		case "Changang-Do":
			return false;
		case "Yanggan-Do":
			return true;
		case "Hamgyong-Bukto":
			return false;
		case "PiYongang Namdo":
			return false;
		case "Pyongyang":
			return true;
		case "Kangwon-Do":
			return false;
		case "Kimchaek":
			return false;
		case "Hamhung":
			return false;
		/**
		 * South Korea
		 */
		case "Incheon":
			return true;
		case "Seoul":
			return true;
		case "Gangwon":
			return true;
		case "Mitan-myeon":
			return false;
		case "Andong":
			return false;
		case "Busan":
			return true;
		case "Gwangju":
			return false;
		case "Daegu":
			return false;
		case "Daejon":
			return true;
		default:
			return false;
		}
	}

	/**
	 * checks if the district has a major airfield
	 * 
	 * @return true if the district has a major airfield
	 */
	public boolean hasAirfield() {
		switch (name) {
		case "Delhi":
			return true;
		case "Haryana":
			return true;
		case "Bathinda":
			return false;
		case "Amritsar":
			return true;
		case "Jammu":
			return true;
		case "Kashmir Valley":
			return false;
		case "Ladakh":
			return false;
		case "Aksai Chin":
			return false;
		case "Himachal":
			return true;
		case "Uttrakhand":
			return false;
		case "Derhadun":
			return true;
		case "Agra":
			return true;
		case "Kanpur":
			return true;
		case "Allahabad":
			return true;
		case "Jaipur":
			return true;
		case "Ajmer":
			return false;
		case "Jodhpur":
			return false;
		case "Ahmedabad":
			return true;
		case "Rann of Kutch":
			return false;
		case "Rajkot":
			return false;
		// but wait, there's more!
		case "Vadodara":
			return true;
		case "Surat":
			return true;
		case "Mumbai":
			return true;
		case "Godhra":
			return false;
		case "Bhopal":
			return true;
		case "Jalagaon":
			return false;
		case "Aurangabad":
			return false;
		case "Poona":
			return true;
		case "Goa":
			return true;
		case "Mangalore":
			return false;
		case "Kochi":
			return true;
		case "Thiruvananthapuram":
			return true;
		case "Madurai":
			return true;
		case "Tirucirappali":
			return false;
		case "Puducherry":
			return false;
		case "Tirvannamalai":
			return false;
		case "Chennai":
			return true;
		case "Ongole":
			return false;
		case "Vishakapatnam":
			return false;
		case "Cuttack":
			return false;
		case "Rourkela":
			return false;
		case "Kolkatta":
			return true;
		case "Asansol":
			return false;
		case "Silliguri":
			return false;
		case "Sikkim":
			return true;
		case "Guwahati":
			return true;
		case "Tezpur":
			return false;
		case "Arunachal Pradesh":
			return false;
		case "Imphal":
			return false;
		case "Mizoram":
			return false;
		case "Muzaffarpur":
			return false;
		case "Patna":
			return true;
		case "Gaya":
			return true;
		case "Ranchi":
			return true;
		case "Jamshedpur":
			return true;
		case "Sitapur":
			return false;
		case "Bliaspur":
			return false;
		case "Raipur":
			return true;
		case "Jagdalpur":
			return false;
		case "Jaisalmer":
			return false;
		case "Palanpur":
			return false;
		case "Hubli":
			return true;
		case "Bangalore":
			return true;
		case "Kozhikode":
			return false;
		case "Tirupati":
			return false;
		case "Cuddupa":
			return false;
		case "Gulbarga":
			return false;
		case "Mysore":
			return false;
		case "Hyderabad":
			return true;
		case "Vijayapura":
			return false;
		case "Solapur":
			return false;
		case "Nanded":
			return false;
		case "Suryapet":
			return false;
		case "Nagpur":
			return true;
		case "Chandrapur":
			return false;
		case "Jhansi":
			return true;
		case "Rewa":
			return false;
		case "Jabalpur":
			return false;
		case "Gwalior":
			return true;
		case "Merut":
			return false;
		case "Lucknow":
			return false;
		case "Faziabad":
			return false;
		case "Bikaner":
			return false;
		case "Combiatore":
			return false;
		case "Kota":
			return true;
		case "Bhagalpur":
			return true;
		case "Tripura":
			return false;
		case "Nizamabad":
			return false;
		case "Balangir":
			return false;
		case "Ganghinagar":
			return true;
		/*
		 * Chinese Districts here
		 */
		case "Beijing":
			return true;
		case "Tianjin":
			return true;
		case "Canzhou":
			return false;
		case "Yantai":
			return false;
		case "Qingdao":
			return true;
		case "Liyanyangang":
			return true;
		case "Yancheng":
			return false;
		case "Nantong":
			return true;
		case "Shanghai":
			return true;
		case "Suzhou":
			return true;
		case "Hangzhou":
			return false;
		case "Jinhua":
			return false;
		case "Zhoushan":
			return false;
		case "Taizhou":
			return false;
		case "Wenzhou":
			return true;
		case "Ningde":
			return false;
		case "Fuzhou":
			return true;
		case "Putian":
			return false;
		case "Xiamen":
			return true;
		case "Hong Kong":
			return true;
		case "Macau":
			return true;
		case "Guangzhou":
			return true;
		case "Zhanjiang":
			return false;
		case "Hainan Dao":
			return true;
		case "Guigang":
			return false;
		case "Wuzhou":
			return true;
		case "Chenzhou":
			return true;
		case "Longyan":
			return false;
		case "Sanming":
			return false;
		case "Quzhou":
			return false;
		case "Huangshan":
			return false;
		case "Jiulong":
			return false;
		case "Changde":
			return true;
		case "Yichang":
			return false;
		case "Yueyang":
			return false;
		case "Huaihua":
			return false;
		case "Hechi":
			return false;
		case "Nanning":
			return false;
		case "Wenshan":
			return true;
		case "Dali":
			return true;
		case "Nyingchi":
			return false;
		case "Lhasa":
			return true;
		case "Ngari":
			return false;
		case "Gerze":
			return false;
		case "Kashgar":
			return false;
		case "Aksu":
			return false;
		case "Yili":
			return false;
		case "Karamay":
			return false;
		case "Kumul":
			return false;
		case "Jiuquan":
			return false;
		case "Haixi":
			return false;
		case "Xining":
			return false;
		case "Xian":
			return true;
		case "Wuhan":
			return true;
		case "Zhuzhou":
			return false;
		case "Yichun":
			return false;
		case "Nanjing":
			return false;
		case "Heifei":
			return false;
		case "Huainan":
			return false;
		case "Bengbu":
			return false;
		case "Xuzhou":
			return true;
		case "Bayingol":
			return false;
		case "Urumqi":
			return false;
		case "Ruoqiang":
			return false;
		case "Dulan":
			return false;
		case "Zekog":
			return false;
		case "Gangu":
			return false;
		case "Chongxin":
			return false;
		case "Chenggu":
			return false;
		case "Qingchuan":
			return false;
		case "Chengdu":
			return true;
		case "Muli":
			return false;
		case "Lhari":
			return false;
		case "Qumarleb":
			return false;
		case "Alxa":
			return false;
		case "Datong":
			return false;
		case "Fengzhen":
			return true;
		case "Chengde":
			return true;
		case "Xilin Gol":
			return false;
		case "Shenyang":
			return true;
		case "Changchun":
			return true;
		case "Mudanjiang":
			return false;
		case "Da Hinggan Ling":
			return false;
		case "Hulun Buir":
			return false;
		case "Baoji":
			return false;
		case "Kunming":
			return true;
		case "Chongquing":
			return true;
		case "Changsha":
			return true;
		case "Chaoyang":
			return false;
		case "Harbin":
			return true;
		case "Suihua":
			return false;
		/*
		 * Mongolian Districts
		 */
		case "Hovd":
			return false;
		case "Uvs":
			return false;
		case "Govi-Altai":
			return false;
		case "Hovsgol":
			return true;
		case "Selenge":
			return false;
		case "South Govi":
			return false;
		case "East Govi":
			return false;
		case "Dornod":
			return false;
		case "Marun":
			return true;
		/*
		 * North Korea
		 */
		case "Changang-Do":
			return false;
		case "Yanggan-Do":
			return true;
		case "Hamgyong-Bukto":
			return false;
		case "PiYongang Namdo":
			return false;
		case "Pyongyang":
			return true;
		case "Kangwon-Do":
			return false;
		case "Kimchaek":
			return false;
		case "Hamhung":
			return false;
		/**
		 * South Korea
		 */
		case "Incheon":
			return true;
		case "Seoul":
			return true;
		case "Gangwon":
			return true;
		case "Mitan-myeon":
			return false;
		case "Andong":
			return false;
		case "Busan":
			return true;
		case "Gwangju":
			return false;
		case "Daegu":
			return false;
		case "Daejon":
			return true;
		default:
			return false;
		}
	}

	protected ArrayList<District> canAirStrike(District thisOne) {
		ArrayList<District> canStrike = new ArrayList<District>();
		// get an ArrayList of all Districts and then check if the distance is
		// less than 1000
		return canStrike;
	}

	/**
	 * 
	 * @return income
	 */
	protected int getIncome() {
		int income = 0;
		if (hasMajorCity)
			income += 35;
		if (hasMajorIndustry)
			income += 23;
		if (hasAirfield)
			income += 15;
		else
			income += 10;
		return income;
	}

	protected Nation isOccupiedBy() {
		return occupied;
	}

	protected Nation belongsTo() {
		return belongsTo;
	}

	protected void buildIndustry() {
		if (!hasMajorIndustry && occupied.getWealth() >= 160) {
			hasMajorIndustry = true;
			occupied.purchase(160);
		} else if (occupied.getWealth() < 160)
			setMessage("Not enough money to build an industry");
	}

	protected void buildCity() {
		if (!hasMajorCity && occupied.getWealth() >= 170) {
			hasMajorCity = true;
			occupied.purchase(170);
		} else if (occupied.getWealth() < 170)
			setMessage("Not enough money to build a big city");
	}

	protected void setMessage(String message) {
		JOptionPane.showMessageDialog(null, "Problem!", message, JOptionPane.INFORMATION_MESSAGE, null);
	}

	protected void buildAirfield() {
		if (!hasAirfield() && occupied.getWealth() >= 200) {
			hasAirfield = true;
			occupied.purchase(200);
		} else if (occupied.getWealth() < 200)
			setMessage("Not enough money to build an airfield");
	}
}
