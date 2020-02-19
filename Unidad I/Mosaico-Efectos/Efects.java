import java.awt.Color;

public class Efects {

	public static Color combine(Color c1, Color c2, double alpha) {
		int r = (int) (alpha * c1.getRed() + (1 - alpha) * c2.getRed());
		int g = (int) (alpha * c1.getGreen() + (1 - alpha) * c2.getGreen());
		int b = (int) (alpha * c1.getBlue() + (1 - alpha) * c2.getBlue());
		return new Color(r, g, b);
	}

	public static Picture fade(int n, String img1, String img2, int m, int w) {

		Picture picture1 = new Picture(img1); // begin picture
		Picture picture2 = new Picture(img2); // end picture
		int width = picture1.width();
		int height = picture1.height();

		Picture picture = new Picture(width, height);
		Picture output;
		for (int k = n / 2; k <= n; k++) {
			double alpha = 1.0 * k / n;
			for (int col = 0; col < width; col++) {
				for (int row = 0; row < height; row++) {
					Color c1 = picture1.get(col, row);
					Color c2 = picture2.get(col, row);
					picture.set(col, row, combine(c2, c1, alpha));
					picture.show();
				}
			}
		}
		return picture;
	}
	
	

	public static Picture rotation(Picture pic1, String angle) {
		int width = pic1.width();
		int height = pic1.height();
		
		double angle1 = Math.toRadians(Double.parseDouble(angle));
		double sin = Math.sin(angle1);
		double cos = Math.cos(angle1);
		double x0 = 0.5 * (width - 1); // point to rotate about
		double y0 = 0.5 * (height - 1); // center of image

		Picture pic2 = new Picture(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				double a = x - x0;
				double b = y - y0;
				int xx = (int) (+a * cos - b * sin + x0);
				int yy = (int) (+a * sin + b * cos + y0);
				if (xx >= 0 && xx < width && yy >= 0 && yy < height) {
					pic2.set(x, y, pic1.get(xx, yy));
				}
			}
		}
		return pic2;
	}

	public static Picture zoom(Picture source, double scale, double x, double y) {
		int width = source.width();
		int height = source.height();
		Picture target = new Picture(width, height);

		for (int colT = 0; colT < width; colT++) {
			for (int rowT = 0; rowT < height; rowT++) {
				int colS = (int) (x * width - width / (2 * scale) + colT / scale);
				int rowS = (int) (y * height - height / (2 * scale) + rowT / scale);
				if (colS < 0 || colS >= width || rowS < 0 || rowS >= height)
					target.set(colT, rowT, Color.BLACK);
				else
					target.set(colT, rowT, source.get(colS, rowS));
			}
		}
		return target;
	}

	public static Picture wave(Picture pic1) {
		int width = pic1.width();
		int height = pic1.height();

		Picture pic2 = new Picture(width, height);

		// wave filter
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int xx = x;
				int yy = (int) (y + 20 * Math.sin(x * 2 * Math.PI / 64));
				if (yy >= 0 && yy < height) {
					pic2.set(x, y, pic1.get(xx, yy));
				}
			}
		}
		return pic2;
	}

	public static Picture threshold(Picture pic) {
		int THRESHOLD = 100;
		for (int i = 0; i < pic.width(); i++) {
			for (int j = 0; j < pic.height(); j++) {
				Color color = pic.get(i, j);
				double lum = Luminance.intensity(color);
				if (lum >= THRESHOLD)
					pic.set(i, j, Color.WHITE);
				else
					pic.set(i, j, Color.BLACK);
			}
		}
		return pic;
	}

	public static Picture scale(Picture source, int width, int height) {
		Picture target = new Picture(width, height);
		for (int targetCol = 0; targetCol < width; targetCol++) {
			for (int targetRow = 0; targetRow < height; targetRow++) {
				int sourceCol = targetCol * source.width() / width;
				int sourceRow = targetRow * source.height() / height;
				Color color = source.get(sourceCol, sourceRow);
				target.set(targetCol, targetRow, color);
			}
		}
		return target;
	}

	public static Picture grayscale(Picture picture) {
		int width = picture.width();
		int height = picture.height();

		// convert to grayscale
		for (int col = 0; col < width; col++) {
			for (int row = 0; row < height; row++) {
				Color color = picture.get(col, row);
				Color gray = Luminance.toGray(color);
				picture.set(col, row, gray);
			}
		}
		return picture;
	}

	public static int random(int a, int b) {
		return a + StdRandom.uniform(b - a + 1);
	}

	public static Picture glass(Picture picture1) {

		int width = picture1.width();
		int height = picture1.height();
		Picture picture2 = new Picture(width, height);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int xx = (width + x + random(-5, 5)) % width;
				int yy = (height + y + random(-5, 5)) % height;
				Color color = picture1.get(xx, yy);
				picture2.set(x, y, color);
			}
		}

		return picture2;
	}
	
	public static Picture flipX(Picture pic ) {
		int width  = pic.width();
        int height = pic.height();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width / 2; x++) {
                Color c1 = pic.get(x, y);
                Color c2 = pic.get(width - x - 1, y);
                pic.set(x, y, c2);
                pic.set(width - x - 1, y, c1);
            }
        }
        return pic;
    }
	
    // truncate color component to be between 0 and 255
    public static int truncate(int a) {
        if      (a <   0) return 0;
        else if (a > 255) return 255;
        else              return a;
    }

    public static Picture edgeDetector(Picture picture) {

        int[][] filter1 = {{ -1,  0,  1 },
            { -2,  0,  2 },
            { -1,  0,  1 }
        };

        int[][] filter2 = {
            {  1,  2,  1 },
            {  0,  0,  0 },
            { -1, -2, -1 }
        };

        int width    = picture.width();
        int height   = picture.height();
        Picture picture1 = new Picture(width, height);

        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {

                // get 3-by-3 array of colors in neighborhood
                int[][] gray = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        gray[i][j] = (int) Luminance.intensity(picture.get(x-1+i, y-1+j));
                    }
                }

                // apply filter
                int gray1 = 0, gray2 = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        gray1 += gray[i][j] * filter1[i][j];
                        gray2 += gray[i][j] * filter2[i][j];
                    }
                }
                // int magnitude = 255 - truncate(Math.abs(gray1) + Math.abs(gray2));
                int magnitude = 255 - truncate((int) Math.sqrt(gray1*gray1 + gray2*gray2));
                Color grayscale = new Color(magnitude, magnitude, magnitude);
                picture1.set(x, y, grayscale);
            }
        }
        return picture1;
    }
    
    public static Picture colorSeparation(Picture picture) {
    	 // read in the picture specified by command-line argument
        int width  = picture.width();
        int height = picture.height();

        // create three empy pictures of the same dimension
        Picture pictureG = new Picture(width, height);
        // separate colors
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color color = picture.get(col, row);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                pictureG.set(col, row, new Color(0, g, 0));
            }
        }
        // display each picture in its own window
        return pictureG;
    }
    
    public static Picture brighter(Picture pic1) {
         int width  = pic1.width();
         int height = pic1.height();
         Picture pic2 = new Picture(width, height);
         for (int x = 0; x < width; x++) {
             for (int y = 0; y < height; y++) {
                 Color c1 = pic1.get(x, y);
                 Color c2 = c1.brighter();
                 pic2.set(x, y, c2);
             }
         }
         return pic2;
    }
    
    

}
