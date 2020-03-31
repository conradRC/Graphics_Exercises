import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bob extends JPanel{
		
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		BasicStroke bs2 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
		g2d.setStroke(bs2);
		
		//camisa
        int[] x = {131, 135, 168, 327, 329, 167};
		int[] y = {343, 366, 367, 350, 322, 336};
		Polygon p = new Polygon(x, y, x.length);
		g2d.setColor(Color.WHITE);
		g2d.drawPolygon(p);
		g2d.fill(p);
		roll(g2d,p);
	
		Line2D.Double line = new Line2D.Double(214,340,230,352);
		Line2D.Double line2 = new Line2D.Double(230,352,241,339);
		
		Line2D.Double line3 = new Line2D.Double(262,330,276,345);
		Line2D.Double line4 = new Line2D.Double(276,345,288,334);
		g2d.setColor(Color.BLACK);
		g2d.fill(line);
		g2d.fill(line2);
		g2d.fill(line3);
		g2d.fill(line4);
		
		g2d.draw(line);
		g2d.draw(line2);
		g2d.draw(line3);
		g2d.draw(line4);
		
		
		
		//pantalones
		
		 int[] x2 = {135, 168, 327, 326, 170, 135};
		 int[] y2 = {366, 367, 350, 381, 400, 392};
		 Polygon p2 = new Polygon(x2, y2, x2.length);
		 g2d.setColor(new Color(184,115,51));
		 g2d.drawPolygon(p2);
		 g2d.fill(p2);
		 roll(g2d,p2);
		 
		 int[] x9 = {142, 142, 155, 155};
		 int[] y9 = {379, 375, 376, 381};
		 Polygon p9 = new Polygon(x9, y9, x9.length);
		 g2d.setColor(Color.black);
		 g2d.drawPolygon(p9);
		 g2d.fill(p9);
		 roll(g2d,p9);
		 
		 int[] x10 = {183, 200, 200, 183};
		 int[] y10 = {375, 374, 378, 379};
		 Polygon p10 = new Polygon(x10, y10, x10.length);
		 g2d.drawPolygon(p10);
		 g2d.fill(p10);
		 roll(g2d,p10);
		 
		 int[] x11 = {220, 240, 240, 220};
		 int[] y11 = {371, 370, 374, 375};
		 Polygon p11 = new Polygon(x11, y11, x11.length);
		 g2d.drawPolygon(p11);
		 g2d.fill(p11);
		 roll(g2d,p11);
		 
		 int[] x12 = {264, 282, 282, 264};
		 int[] y12 = {367, 366, 371, 372};
		 Polygon p12 = new Polygon(x12, y12, x12.length);
		 g2d.drawPolygon(p12);
		 g2d.fill(p12);
		 roll(g2d,p12);
		 
		 int[] x13 = {299, 314, 314, 299};
		 int[] y13 = {363, 361, 366, 368};
		 Polygon p13 = new Polygon(x13, y13, x13.length);
		 g2d.drawPolygon(p13);
		 g2d.fill(p13);
		 roll(g2d,p13);
		 
		//corbata
		 GeneralPath gp1 = new GeneralPath();
			gp1.moveTo(243,327);
			gp1.curveTo(243,327,242,342,250,349);
			gp1.curveTo(250,349,264,349,262,324);
			g2d.setColor(Color.red);
			g2d.fill(gp1);
			g2d.draw(gp1);
			roll(g2d,gp1);
			
			//manga derecha
		     GeneralPath gpmi = new GeneralPath();
		     gpmi.moveTo(333,265);	
		     gpmi.curveTo(333,265,350,268,356,281);
				gpmi.curveTo(356,281,360,287,350,298);
				gpmi.curveTo(350,298,349,306,330,307);
		     g2d.setColor(Color.white);
			g2d.fill(gpmi);
			g2d.draw(gpmi);
			roll(g2d,gpmi);	
			
			GeneralPath gpld = new GeneralPath();
			gpld.moveTo(334,296);
			gpld.curveTo(334,296,339,289,346,285);
			g2d.setColor(Color.black);
			g2d.fill(gpld);
			g2d.draw(gpld);
		
		//********BODY*******
		GeneralPath generalPath = new GeneralPath();
		generalPath.moveTo(119,164);
		generalPath.curveTo(119,164,129,156,139,158);
		generalPath.curveTo(139,158,151,161,157,154);
        generalPath.curveTo(157,154,163,150,175,153);
        generalPath.curveTo(175,153,185,158,196,150);
        generalPath.curveTo(196,150,209,145,220,146);
        generalPath.curveTo(220,146,233,153,243,144);
        generalPath.curveTo(243,144,255,140,266,144);
        generalPath.curveTo(266,144,280,150,295,136);
        generalPath.curveTo(295,136,310,139,310,155);
        generalPath.curveTo(310,155,305,177,316,186);
        generalPath.curveTo(316,186,330,198,323,221);
        generalPath.curveTo(323,221,319,232,327,244);
        generalPath.curveTo(327,244,336,263,330,278);
        generalPath.curveTo(330,278,327,288,331,299);
        generalPath.curveTo(331,299,338,309,334,320);
        generalPath.curveTo(334,320,326,330,312,325);
        generalPath.curveTo(312,325,303,325,299,332);
        generalPath.curveTo(299,332,286,335,275,329);
        generalPath.curveTo(275,329,264,324,255,331);
        generalPath.curveTo(255,331,247,337,235,333);
        generalPath.curveTo(235,333,226,328,216,334);
        generalPath.curveTo(216,334,206,340,194,336);
        generalPath.lineTo(172,340);
        generalPath.curveTo(172,340,162,332,169,316);
        generalPath.curveTo(169,316,169,301,162,293);
        generalPath.curveTo(162,293,153,285,155,270);
        generalPath.curveTo(155,270,159,255,147,240);
        generalPath.curveTo(147,240,138,230,140,207);
        generalPath.curveTo(140,207,142,193,130,180);
        generalPath.curveTo(130,180,121,175,119,164);
        
        g2d.setColor(new Color(243,243,26));
        g2d.fill(generalPath);
        generalPath.closePath();
        g2d.draw(generalPath);
        roll(g2d,generalPath);
        
        GeneralPath generalPath1 = new GeneralPath();
        generalPath1.moveTo(119,164);
        generalPath1.curveTo(119,164,117,188,108,184);
        generalPath1.curveTo(108,184,100,186,99,199);
        generalPath1.curveTo(99,199,98,206,90,208);
        generalPath1.curveTo(90,208,83,218,92,227);
        generalPath1.curveTo(92,227,105,236,103,247);
        generalPath1.curveTo(103,247,100,256,111,266);
       	generalPath1.curveTo(111,266,121,274,121,287);
       	generalPath1.curveTo(121,287,119,303,126,310);
       	generalPath1.curveTo(126,310,131,321,128,331);
       	generalPath1.curveTo(128,331,126,339,131,345);
       	generalPath1.curveTo(131,345,139,340,144,345);
       	generalPath1.curveTo(144,345,146,348,151,340);
       	generalPath1.curveTo(151,340,154,337,159,341);
       	generalPath1.curveTo(159,341,163,342,172,339);//cierre, inferior izquierdo
       	generalPath1.curveTo(172,339,162,332,169,316);
        generalPath1.curveTo(169,316,169,301,162,293);
        generalPath1.curveTo(162,293,153,285,155,270);
        generalPath1.curveTo(155,270,159,255,147,240);
        generalPath1.curveTo(147,240,138,230,140,207);
        generalPath1.curveTo(140,207,142,193,130,180);
        generalPath1.curveTo(130,180,121,175,119,164);
       	
       	g2d.setColor(new Color(210,210,0));
        g2d.fill(generalPath1);
        g2d.draw(generalPath1);
        roll(g2d,generalPath1);
        
         //manga izquierda
		    GeneralPath gpi = new GeneralPath();
			gpi.moveTo(135,290);
			gpi.curveTo(135,290,122,320,140,330);
			gpi.curveTo(140,331,153,329,159,322);
			gpi.curveTo(159,322,165,311,161,302);
			gpi.curveTo(161,302,155,291,140,286);
			g2d.setColor(Color.white);
			g2d.fill(gpi);
			g2d.draw(gpi);
			roll(g2d,gpi);
			
			GeneralPath gpli = new GeneralPath();
			gpli.moveTo(151,315);
			gpli.curveTo(151,315,140,313,135,323);
			g2d.setColor(Color.black);
			g2d.fill(gpli);
			g2d.draw(gpli);
			
			
	         //brazo
			    GeneralPath gpbi = new GeneralPath();
			    gpbi.moveTo(141,317);
				gpbi.curveTo(141,317,146,341,157,353);
				gpbi.curveTo(157,353,160,359,170,352);
				gpbi.lineTo(188,335);
				gpbi.curveTo(188,335,210,332,216,315);
				gpbi.curveTo(216,315,217,307,211,308);
				gpbi.lineTo(202,319);
				gpbi.moveTo(211,308);
				gpbi.curveTo(211,308,213,298,207,301);
				gpbi.lineTo(198,314);
				gpbi.moveTo(207,301);
				gpbi.curveTo(207,301,207,294,201,298);
				gpbi.curveTo(201,298,196,303,192,307);
				gpbi.curveTo(192,307,188,311,188,317);
				gpbi.curveTo(188,317,188,311,187,308);
				gpbi.curveTo(187,308,184,302,179,308);
				gpbi.curveTo(179,308,184,312,181,320);
				gpbi.curveTo(181,320,180,321,184,327);
				gpbi.lineTo(172,341);
				gpbi.curveTo(172,341,163,351,159,342);
				gpbi.curveTo(159,342,153,335,148,317);
			
				g2d.setColor(new Color(243,243,26));
				g2d.fill(gpbi);
				g2d.draw(gpbi);
				
				roll(g2d,gpbi);
			
     
				//brazo derecho
				GeneralPath gpbd = new GeneralPath();
				gpbd.moveTo(345,290);
				gpbd.lineTo(345,290);
				gpbd.lineTo(383,342);
				gpbd.curveTo(383,342,393,339,401,345);
				gpbd.lineTo(395,349);
				gpbd.moveTo(401,345);
				gpbd.curveTo(401,345,417,343,414,351);
				gpbd.lineTo(395,353);
				gpbd.moveTo(414,351);
				gpbd.curveTo(414,351,420,360,414,362);
				gpbd.curveTo(414,362,416,364,406,364);
				gpbd.curveTo(406,364,397,359,389,362);
				gpbd.curveTo(389,362,374,372,376,359);
				gpbd.curveTo(376,359,382,357,377,350);
				gpbd.lineTo(338,296);
				
			    g2d.setColor(new Color(243,243,26));
				g2d.fill(gpbd);
				g2d.draw(gpbd);
				roll(g2d,gpbd);
				
				//part pantalon derecho
				GeneralPath gppd = new GeneralPath();
				gppd.moveTo(166,401);
				gppd.curveTo(166,401,161,403,158,410);
				gppd.curveTo(158,410,164,421,174,423);
				gppd.curveTo(174,423,197,426,205,414);
				gppd.curveTo(205,414,205,406,200,398);
				g2d.setColor(new Color(184,115,51));
				
				g2d.fill(gppd);
				g2d.draw(gppd);
				roll(g2d,gppd);
		
				//pierna
				int[] xp = {170,159,168,181};
				int[] yp = {424,466,473,425};
				Polygon pp = new Polygon(xp, yp, xp.length);
				g2d.setColor(new Color(243,243,26));
				g2d.drawPolygon(pp);
				g2d.fill(pp);
				roll(g2d,pp);
				
				//calcetines
				GeneralPath gpbp = new GeneralPath();
				gpbp.moveTo(166,442);
				gpbp.curveTo(166,443,170,448,173,446);
				gpbp.lineTo(169,471);
				gpbp.lineTo(159,468);
				
				g2d.setColor(Color.white);
				g2d.fill(gpbp);
				g2d.draw(gpbp);
				roll(g2d,gpbp);
				
				
				//zaapto derecho
				GeneralPath gpbz = new GeneralPath();
				gpbz.moveTo(160,467);
				gpbz.curveTo(160,467,149,467,151,481);
				gpbz.curveTo(151,481,133,490,145,507);
				gpbz.curveTo(145,507,156,512,170,506);
				gpbz.curveTo(170,506,180,496,174,484);
				gpbz.curveTo(174,484,177,477,171,471);
				gpbz.curveTo(171,471,155,474,160,467);
				
				g2d.setColor(Color.black);
				g2d.fill(gpbz);
				g2d.draw(gpbz);
				roll(g2d,gpbz);
				
				Ellipse2D.Double e = new Ellipse2D.Double(156,485,9,9);
				g2d.setColor(Color.white);
				g2d.fill(e);
				g2d.draw(e);
				
			
				//part pant izquierda
				
				GeneralPath gppi = new GeneralPath();
				gppi.moveTo(294,386);
				gppi.curveTo(294,386,299,402,295,408);
				gppi.curveTo(295,408,290,414,269,413);
				gppi.curveTo(269,413,254,410,243,392);
				
				g2d.setColor(new Color(184,115,51));
				g2d.fill(gppi);
				g2d.draw(gppi);
				roll(g2d,gppi);
				
				
				//pierna
				int[] xp2 = {263,242,252,272};
				int[] yp2 = {410,468,470,414};
				Polygon pp2 = new Polygon(xp2, yp2, xp2.length);
				g2d.setColor(new Color(243,243,26));
				g2d.drawPolygon(pp2);
				g2d.fill(pp2);
				roll(g2d,pp2);
				
				//calcetines
				GeneralPath gpbc = new GeneralPath();
				gpbc.moveTo(253,438);
				gpbc.curveTo(253,438,255,443,261,441);
				gpbc.lineTo(253,467);
				gpbc.curveTo(253,467,248,472,243,467);
				
				g2d.setColor(Color.white);
				g2d.fill(gpbc);
				g2d.draw(gpbc);
				roll(g2d,gpbc);
			
				//zaapto derecho
				GeneralPath gpbzi = new GeneralPath();
				gpbzi.moveTo(241,464);
				gpbzi.curveTo(241,464,250,470,254,464);
				gpbzi.lineTo(260,471);
				gpbzi.curveTo(260,471,277,452,282,476);
				gpbzi.curveTo(282,476,284,486,268,495);
				gpbzi.curveTo(268,495,261,497,253,487);
				gpbzi.curveTo(253,487,243,472,246,490);
				gpbzi.curveTo(246,490,227,482,235,479);
				gpbzi.curveTo(235,479,233,469,243,463);
				
				g2d.setColor(Color.black);
				g2d.fill(gpbzi);
				g2d.draw(gpbzi);
				roll(g2d,gpbzi);
				
				Ellipse2D.Double e1 = new Ellipse2D.Double(268,468,9,9);
				g2d.setColor(Color.white);
				g2d.fill(e1);
				g2d.draw(e1);
				
				
				
			//corbata parte II
			int[] x0 = {251, 251, 258, 274, 256, 256, 232};
			int[] y0 = {349, 349, 348, 380, 404, 404, 383};
			Polygon p0 = new Polygon(x0, y0, x0.length);
			g2d.setColor(Color.RED);
			g2d.drawPolygon(p0);
			g2d.fill(p0);
			roll(g2d,p0);
			
			//rostro
			
			//cahcete derecho
			GeneralPath gpcd = new GeneralPath();
			gpcd.moveTo(180,248);
			gpcd.curveTo(180,248,206,239,219,255);
			gpcd.curveTo(219,255,220,274,204,281);
			gpcd.curveTo(204,281,193,283,187,281);
			
			g2d.setColor(Color.red);
			g2d.draw(gpcd);
			roll(g2d,gpcd);
			 

			//boca
			GeneralPath gpbo = new GeneralPath();
			gpbo.moveTo(221,265);
			gpbo.curveTo(221,265,251,276,274,257);
			
			gpbo.moveTo(257,250);
			gpbo.curveTo(257,250,273,252,281,244);
			gpbo.curveTo(281,244,287,240,281,233);
			gpbo.curveTo(281,233,273,230,266,238);
			gpbo.curveTo(266,238,263,241,252,240);
			
			gpbo.moveTo(255,289);
			gpbo.curveTo(255,289,260,295,256,303);
			
			gpbo.moveTo(242,290);
			gpbo.curveTo(242,290,243,298,239,301);
			
			
			g2d.setColor(Color.black);
			g2d.draw(gpbo);
			roll(g2d,gpbo);
			
			//cachete iz
			GeneralPath gpci = new GeneralPath();
			gpci.moveTo(306,260);
			gpci.curveTo(306,260,286,266,275,250);
			
			gpci.moveTo(276,232);
			gpci.curveTo(276,232,285,221,303,222);
			g2d.setColor(Color.red);
			g2d.draw(gpci);
			roll(g2d,gpci);
			
			
			//ojo
			GeneralPath gpco = new GeneralPath();
			gpco.moveTo(187,245);
			gpco.curveTo(187,245,166,239,173,209);
			gpco.curveTo(173,209,176,188,194,178);
			gpco.curveTo(194,178,209,170,222,180);
			gpco.curveTo(222,180,234,184,241,215);
			gpco.curveTo(241,215,243,240,215,249);
			
			g2d.setColor(Color.white);
			g2d.fill(gpco);
			g2d.draw(gpco);
			roll(g2d,gpco);
			
			//azul
			GeneralPath gpcoi = new GeneralPath();
			gpcoi.moveTo(216,177);
			gpcoi.curveTo(216,177,196,197,207,222);
			gpcoi.curveTo(207,222,218,239,239,228);
			
			g2d.setColor(Color.blue);
			g2d.fill(gpcoi);
			g2d.draw(gpcoi);
			roll(g2d,gpcoi);
			
			//negro
			GeneralPath gpcoin = new GeneralPath();
			gpcoin.moveTo(216,177);
			gpcoin.curveTo(216,177,197,213,221,223);
			gpcoin.curveTo(221,223,231,229,237,224);
			gpcoin.curveTo(237,224,257,198,212,177);

			g2d.setColor(Color.black);
			g2d.fill(gpcoin);
			g2d.draw(gpcoin);
			roll(g2d,gpcoin);
			
			Ellipse2D.Double oj = new Ellipse2D.Double(208,188,22,29);
			g2d.setColor(Color.white);
			g2d.fill(oj);
			g2d.draw(oj);
			
			Ellipse2D.Double oj1 = new Ellipse2D.Double(229,213,9,11);
			g2d.setColor(Color.white);
			g2d.fill(oj1);
			g2d.draw(oj1);
			
			
			//ojo i
			GeneralPath gpcoj = new GeneralPath();
			gpcoj.moveTo(256,238);
			gpcoj.curveTo(256,238,246,237,241,225);
			gpcoj.curveTo(241,225,244,213,238,197);
			gpcoj.curveTo(238,197,238,175,257,170);
			gpcoj.curveTo(257,170,268,168,273,171);
			gpcoj.curveTo(278,171,294,184,295,203);
			gpcoj.curveTo(295,203,297,216,290,224);
			gpcoj.curveTo(290,224,285,223,279,229);
			gpcoj.curveTo(279,229,274,228,263,238);
			
			g2d.setColor(Color.white);
			g2d.fill(gpcoj);
			g2d.draw(gpcoj);
			roll(g2d,gpcoj);
			
			GeneralPath gpcoia = new GeneralPath();
			gpcoia.moveTo(267,170);
			gpcoia.curveTo(267,170,243,196,265,217);
			gpcoia.curveTo(265,217,288,230,294,210);
			
			g2d.setColor(Color.blue);
			g2d.fill(gpcoia);
			g2d.draw(gpcoia);
			roll(g2d,gpcoia);
				
			
			//negro
			GeneralPath gpcoinb = new GeneralPath();
			gpcoinb.moveTo(267,170);
			gpcoinb.curveTo(267,170,250,203,280,215);
			gpcoinb.curveTo(280,215,288,217,294,207);
			gpcoinb.curveTo(294,207,300,180,267,170);
			

			g2d.setColor(Color.black);
			g2d.fill(gpcoinb);
			g2d.draw(gpcoinb);
			roll(g2d,gpcoinb);
			
			Ellipse2D.Double oj0 = new Ellipse2D.Double(261,179,22,29);
			g2d.setColor(Color.white);
			g2d.fill(oj0);
			g2d.draw(oj0);
			
			Ellipse2D.Double oj2 = new Ellipse2D.Double(282,204,9,11);
			g2d.setColor(Color.white);
			g2d.fill(oj2);
			g2d.draw(oj2);
			
			
			//dientes
			int[] xpd = {231,230,245,244};
			int[] ypd = {269,282,282,269};
			Polygon ppd = new Polygon(xpd, ypd, xpd.length);
			g2d.setColor(Color.white);
			g2d.drawPolygon(ppd);
			g2d.fill(ppd);
			roll(g2d,ppd);
			
			
			int[] xpdi = {254,254,268,265};
			int[] ypdi = {269,280,278,262};
			Polygon ppdi = new Polygon(xpdi, ypdi, xpdi.length);
			g2d.setColor(Color.white);
			g2d.drawPolygon(ppdi);
			g2d.fill(ppdi);
			roll(g2d,ppdi);
			
			
			
			//extrs
			Ellipse2D.Double ex = new Ellipse2D.Double(108,207,22,29);
		 	g2d.setColor(new Color(185,185,0));
			g2d.fill(ex);
			g2d.draw(ex);
			roll(g2d,ex);
			
			Ellipse2D.Double ex1 = new Ellipse2D.Double(127,251,7,9);
			g2d.setColor(new Color(185,185,0));
			g2d.fill(ex1);
			g2d.draw(ex1);
			roll(g2d,ex1);
			
			Ellipse2D.Double ex2 = new Ellipse2D.Double(149,173,22,29);
			g2d.setColor(new Color(185,185,0));
			g2d.fill(ex2);
			g2d.draw(ex2);
			roll(g2d,ex2);
			
			Ellipse2D.Double ex3 = new Ellipse2D.Double(155,223,10,15);
			g2d.setColor(new Color(185,185,0));
			g2d.fill(ex3);
			g2d.draw(ex3);
			roll(g2d,ex3);
			
			Ellipse2D.Double ex4 = new Ellipse2D.Double(178,282,9,11);
			g2d.setColor(new Color(185,185,0));
			g2d.fill(ex4);
			g2d.draw(ex4);
			roll(g2d,ex4);
			
			Ellipse2D.Double ex5 = new Ellipse2D.Double(300,281,17,24);
			g2d.setColor(new Color(185,185,0));
			g2d.fill(ex5);
			g2d.draw(ex5);
			roll(g2d,ex5);
			
			Ellipse2D.Double ex6 = new Ellipse2D.Double(300,281,17,24);
			g2d.setColor(new Color(185,185,0));
			g2d.fill(ex6);
			g2d.draw(ex6);
			roll(g2d,ex6);
			
			Ellipse2D.Double ex7 = new Ellipse2D.Double(311,311,7,8);
			g2d.setColor(new Color(185,185,0));
			g2d.fill(ex7);
			g2d.draw(ex7);
			roll(g2d,ex7);
			
			Ellipse2D.Double ex8 = new Ellipse2D.Double(290,153,9,12);
			g2d.setColor(new Color(185,185,0));
			g2d.fill(ex8);
			g2d.draw(ex8);
			roll(g2d,ex8);
			
			
			BasicStroke bs3 = new BasicStroke(6);
			g2d.setStroke(bs3);
			
			//cejas
			Line2D.Double ll = new Line2D.Double(176,179,182,187);
			g2d.draw(ll);
			
			Line2D.Double ll1 = new Line2D.Double(194,165,197,175);
			g2d.draw(ll1);
			
			Line2D.Double ll2 = new Line2D.Double(218,167,216,176);
			g2d.draw(ll2);
			
			Line2D.Double ll3 = new Line2D.Double(218,167,216,176);
			g2d.draw(ll3);
			
			Line2D.Double ll4 = new Line2D.Double(261,157,264,170);
			g2d.draw(ll4);
			
			Line2D.Double ll5 = new Line2D.Double(285,159,280,169);
			g2d.draw(ll5);
			
			Line2D.Double ll6 = new Line2D.Double(238,167,246,175);
			g2d.draw(ll6);
			
			BasicStroke bs4 = new BasicStroke(2);
			g2d.setStroke(bs4);
			
			Line2D.Double p1 = new Line2D.Double(167,368,168,393);
			g2d.draw(p1);
			
			Line2D.Double pl1 = new Line2D.Double(167,368,167,356);
			g2d.draw(pl1);
	}
	
	
	public void roll(Graphics2D g2d, GeneralPath gp) {
		g2d.setColor(Color.BLACK);
		g2d.draw(gp);
	}
	
	public void roll(Graphics2D g2d, Polygon gp) {
		g2d.setColor(Color.BLACK);
		g2d.draw(gp);
	}
	
	public void roll(Graphics2D g2d, Ellipse2D.Double gp) {
		g2d.setColor(Color.BLACK);
		g2d.draw(gp);
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Perla - Bob Esponja");
		frame.setBackground(Color.pink);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(550, 600);
		frame.setLocationRelativeTo(null);
		frame.add(new Bob());
		frame.setVisible(true);
	}
}


