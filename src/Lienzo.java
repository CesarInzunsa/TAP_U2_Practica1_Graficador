
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author cesar
 */
public class Lienzo extends Canvas implements Serializable{
    
    private String[] titulosX;
    private String[] titulosY;
    private int[] valores;
    
    private Color color;
    private int yMax;
    
    private int[] valoresAux;
    private int yMaxValores;
    private tipoTitulo tipo;
    
    public enum tipoTitulo{
        CADENA, NUMERICO;
    }
    
    public Lienzo(){
        String[] x = {"X1","X2"};
        this.titulosX = x;
        
        String[] y = {"Y1","Y2"};
        this.titulosY = y;
        
        int[] v = {100,50};
        this.valores = v;
        
        this.color = Color.GREEN;
        
        this.yMax = 240;
        this.tipo = tipoTitulo.NUMERICO;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.WHITE);
        
        valoresAux = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            valoresAux[i] = valores[i];
        }
        Arrays.sort(valoresAux);
        this.yMaxValores = valoresAux[valoresAux.length-1];
        
        //graficar(titulosX, titulosY, valores);
        
        
        
        //EJE X y Y
        dibujarEjes(g);
        
        //Dibujar
        if (yMax == 240 && yMaxValores <= 240) {
            
            //Dibujar barras
            dibujarBarras(g);
            
            //Dibujar titulosY
            if (tipo == tipoTitulo.CADENA) {
                dibujarTitulosY(g);
            }else{
                dibujarTituloYConValores(g);
            }
        }else{
            
            if (yMaxValores <= yMax) {
                //Dibujar barras
                dibujarBarrasPorcentaje(g);
            
                //Dibujar titulosY
                if (tipo == tipoTitulo.CADENA) {
                    dibujarTitulosYPorcentaje(g);
                }else{
                    dibujarTituloYConValoresPorcentaje(g);
                }
            }else{
                
            }
            
        }
        
        //Generar titulosX
        dibujarTitulosX(g);
    }
    /*
    public void graficar(String[] titulosX, String[] titulosY, int[] valores){
        this.titulosX = titulosX;
        this.titulosY = titulosY;
        this.valores = valores;
    }
*/
    public String[] getTitulosX() {
        return titulosX;
    }

    public void setTitulosX(String[] titulosX) {
        this.titulosX = titulosX;
    }

    public String[] getTitulosY() {
        return titulosY;
    }

    public void setTitulosY(String[] titulosY) {
        this.titulosY = titulosY;
    }

    public int[] getValores() {
        return valores;
    }

    public void setValores(int[] valores) {
        this.valores = valores;
    }
    
    public int[] getValoresAux() {
        return valoresAux;
    }

    public void setValoresAux(int[] valoresAux) {
        this.valoresAux = valoresAux;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getyMax() {
        return yMax;
    }

    public void setyMax(int yMax) {
        this.yMax = yMax;
    }    
    
    public void setTipoTitulo(tipoTitulo tipo){
        this.tipo = tipo;
    }
    
    public tipoTitulo getTipoTitulo(){
        return this.tipo;
    }

    private void dibujarBarras(Graphics g) {
        int espT = 50;
        for (int i = 0; i < valores.length; i++) {
            g.setColor(color);
            g.fillRect(espT,(250-valores[i]),50,valores[i]);
            g.setColor(Color.black);
            g.drawRect(espT,(250-valores[i]),50,valores[i]);
            espT += 50;
        }
    }
    
    private void dibujarBarrasPorcentaje(Graphics g){
        
        int espT = 50;
        for (int i = 0; i < valores.length; i++) {
            
            int porcentaje = (valores[i] * 100) / yMax;
            int px240 = (porcentaje * 240)/100;
            
            g.setColor(color);
            g.fillRect(espT,(250-px240),50,px240);
            g.setColor(Color.black);
            g.drawRect(espT,(250-px240),50,px240);
            espT += 50;
        }
    }

    private void dibujarEjes(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(0, 250, 400, 250);
        g.drawLine(50, 0, 50, 300);
    }

    private void dibujarTitulosY(Graphics g) {
        //ordenarValores();
        g.setColor(Color.BLACK);
        for (int i = 0; i < titulosY.length; i++) {
            
            if (valoresAux[i] == 240) {
                g.drawString(yMax+"", 3, (250-240)+5);
                g.drawLine(47, (250-240), 53, (250-240));
            }else{
                g.drawString(titulosY[i], 3, (250-valoresAux[i])+5);
                g.drawLine(47, (250-valoresAux[i]), 53, (250-valoresAux[i]));
            }
        }
        
        g.drawString(yMax+"", 3, (250-240)+5);
        g.drawLine(47, (250-240), 53, (250-240));
    }
    
    private void dibujarTitulosYPorcentaje(Graphics g){
        g.setColor(Color.BLACK);
        for (int i = 0; i < titulosY.length; i++) {
            
            int porcentaje = (valoresAux[i] * 100) / yMax;
            int px240 = (porcentaje * 240)/100;
            
            if (valoresAux[i] == yMax) {
                g.drawString(yMax+"", 3, (250-240)+5);
                g.drawLine(47, (250-240), 53, (250-240));
            }else{
                g.drawString(titulosY[i], 3, (250-px240)+5);
                g.drawLine(47, (250-px240), 53, (250-px240));
            }
        }
        
        g.drawString(yMax+"", 3, (250-240)+5);
        g.drawLine(47, (250-240), 53, (250-240));
        
    }

    private void dibujarTitulosX(Graphics g) {
        int espX = 53;
        g.setColor(Color.BLACK);
        for (String titulosX1 : titulosX) {
            g.drawString(titulosX1, espX, 270);
            espX += 50;
        }
    }

    private void ordenarValores() {
        int temporal = 0;
        
        for (int i = 0; i < valoresAux.length; i++) {
            for (int j = 1; j < (valoresAux.length - i); j++) {
                if (valoresAux[j - 1] > valoresAux[j]) {
                    temporal = valoresAux[j - 1];
                    valoresAux[j - 1] = valoresAux[j];
                    valoresAux[j] = temporal;
                }
            }
        }
    }
    
    private void dibujarTituloYConValores(Graphics g){
        //ordenarValores();
        
        
        g.setColor(Color.BLACK);
        for (int i = 0; i < valores.length; i++) {
            g.drawString(valoresAux[i]+"", 3, (250-valoresAux[i])+5);
            g.drawLine(47, (250-valoresAux[i]), 53, (250-valoresAux[i]));
        }
        
        g.drawString(yMax+"", 3, (250-240)+5);
        g.drawLine(47, (250-240), 53, (250-240));
    }
    
    private void dibujarTituloYConValoresPorcentaje(Graphics g){
        
        
        g.setColor(Color.BLACK);
        for (int i = 0; i < valores.length; i++) {
            
            int porcentaje = (valoresAux[i] * 100) / yMax;
            int px240 = (porcentaje * 240)/100;
            
            g.drawString(valoresAux[i]+"", 3, (250-px240)+5);
            g.drawLine(47, (250-px240), 53, (250-px240));
        }
        
        g.drawString(yMax+"", 3, (250-240)+5);
        g.drawLine(47, (250-240), 53, (250-240));
    }
    
}
