package presenter;


import java.awt.event.ActionEvent;


public class VerificationPresenter extends MainPresenter {
    public VerificationPresenter(){
        view.createPanelLogin(this);
    }


    /**
    public void dataVerification() {
        pr.crearPropertiesFile();
        String nombreUsuario="";
        String password="";
        //nombreUsuario = viewText.user();
        if(pr.getDatos().get(0).equals(nombreUsuario)) {
            password = viewText.password();
            if (pr.getDatos().get(1).equals(password)) {
                view.createPanelInventoryAdm(this);
            }else {
                view.notifyWarning("La clave ingresada es incorrecta");
            }
        }else {
            view.notifyWarning("Información incorrecta");
        }
    }

     */

    /**
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Administrador")) {
            view.createPanelLV(this);
        }
        if(e.getActionCommand().equals("Submit")) {
            dataVerification();
        }
    }
    public static void main(String[] args) {
        new VerificationPresenter();
    }

    */
}