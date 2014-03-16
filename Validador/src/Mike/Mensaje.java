/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mike;

/**
 *
 * @author PC-Ciudad Deseada
 */
public class Mensaje {
    private String Destinatario;
    private String Asunto;
    private String Cuerpo;
    public Mensaje() {
    }

    public Mensaje(String Destinatario, String Asunto, String Cuerpo) {
        this.Destinatario = Destinatario;
        this.Asunto = Asunto;
        this.Cuerpo = Cuerpo;
    }

    public String getDestinatario() {
        return Destinatario;
    }

    public void setDestinatario(String Destinatario) {
        this.Destinatario = Destinatario;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    public String getCuerpo() {
        return Cuerpo;
    }

    public void setCuerpo(String Cuerpo) {
        this.Cuerpo = Cuerpo;
    }
    
}
