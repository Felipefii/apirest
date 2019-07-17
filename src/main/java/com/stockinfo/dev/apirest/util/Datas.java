package com.stockinfo.dev.apirest.util;

import java.util.Date;

import com.stockinfo.dev.apirest.model.Participante;

public class Datas {
	
	
	public int difMeses(Participante participante) {
		
		int dif, m1,m2;
		Date date = new Date();
		m1 = participante.getConta().getDataInscricao().getYear() * 12 + participante.getConta().getDataInscricao().getMonth();
		m2 = date.getYear() * 12 + date.getMonth();
		
		return m2-m1;
	}
	
}
