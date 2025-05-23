/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package mx.itson.iniciosesion.ui;

import static com.iniciosesion.encriptado.EncriptacionAES.encriptar;
import com.iniciosesion.entidades.Colaborador;
import javax.swing.JOptionPane;
import com.iniciosesion.persistencia.ColaboradorDAO;

/**
 * Clase para añadir un nuevo registro de tipo colaborador en su respectiva
 * tabla.
 * @author darkheaven
 */
public class RegistroDialog extends javax.swing.JDialog {

    /**
     * Creates new form RegistroDialog
     */
    public RegistroDialog(java.awt.Frame parent, boolean modal) {
        super(parent, "Registro de cuenta", true);
        initComponents();
    }

    /**
     * Método para validar si se rellenaron los campos de información del 
     * registro.
     * @return true or false
     */
    private boolean validarCamposVacios() {
    if (txtNombre.getText().trim().isEmpty()) {
        mostrarError("Nombre", "No se ha ingresado un nombre");
        return true;
    }
    
    if (txtCorreo.getText().trim().isEmpty()) {
        mostrarError("Correo", "No se ha ingresado un correo");
        return true;
    }
    
    if (pwContrasenia.getPassword().length == 0) {
        mostrarError("Contraseña", "No se ha ingresado una contraseña");
        return true;
    }
    
    if (pwVerificacionContrasenia.getPassword().length == 0) {
        mostrarError("Verificación", "No se ha ingresado la verificación de contraseña");
        return true;
    }
    
    return false;
}

    /**
     * Método para dar formato a los mensajes de error.
     * @param campo área donde se produjo el error.
     * @param mensaje texto a mostrar
     */
    private void mostrarError(String campo, String mensaje) {
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Error en campo: " + campo,
                JOptionPane.ERROR_MESSAGE
    );
 }
   
    /**
     * Método para validar que el formato del correo este correcto.
     * @return true or false
     */
    private boolean validarFormatoCorreo() {
    String correo = txtCorreo.getText().trim();
    // Expresión regular para validar correo electrónico
    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    
    if (!correo.matches(regex)) {
        mostrarError("Correo", "El formato del correo no es válido. Debe ser ejemplo@dominio.com");
        txtCorreo.requestFocus();
        return false;
    }
    return true;
}
    
    /**
     * Método para validar que la contraseña a ingresar en el registro cumpla
     * con los requisitos minimos.
     * @return true or false
     */
    private boolean validarRequisitosContrasenia() {
    String contrasenia = new String(pwContrasenia.getPassword());
    
    // Requisitos mínimos para una contraseña:
    // Al menos 8 caracteres
    // Al menos una mayúscula
    // Al menos una minúscula
    // Al menos un número
    // Al menos un carácter especial
    
    if (contrasenia.length() < 8) {
        mostrarError("Contraseña", "La contraseña debe tener al menos 8 caracteres");
        pwContrasenia.requestFocus();
        return false;
    }
    
    if (!contrasenia.matches(".*[A-Z].*")) {
        mostrarError("Contraseña", "La contraseña debe contener al menos una letra mayúscula");
        pwContrasenia.requestFocus();
        return false;
    }
    
    if (!contrasenia.matches(".*[a-z].*")) {
        mostrarError("Contraseña", "La contraseña debe contener al menos una letra minúscula");
        pwContrasenia.requestFocus();
        return false;
    }
    
    if (!contrasenia.matches(".*[0-9].*")) {
        mostrarError("Contraseña", "La contraseña debe contener al menos un número");
        pwContrasenia.requestFocus();
        return false;
    }
    
    if (!contrasenia.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
        mostrarError("Contraseña", "La contraseña debe contener al menos un carácter especial");
        pwContrasenia.requestFocus();
        return false;
    }
    
    return true;
}

    /**
     * Método para validar que ambos campos de contraseñas coincidan.
     * @return true or false
     */
    private boolean validarContrasenias() {
        String contrasenia = new String(pwContrasenia.getPassword());
        String verificacion = new String(pwVerificacionContrasenia.getPassword());
    
        if (!contrasenia.equals(verificacion)) {
            mostrarError("Contraseñas", "Las contraseñas no coinciden");
            pwContrasenia.requestFocus();
            return false;
        }
        return true;
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        pwContrasenia = new javax.swing.JPasswordField();
        pwVerificacionContrasenia = new javax.swing.JPasswordField();
        lblContrasenia = new javax.swing.JLabel();
        lblVerificacionContrasenia = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblRegistro = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        lblNombre.setFont(new java.awt.Font("DialogInput", 0, 15)); // NOI18N
        lblNombre.setText("Nombre:");

        lblCorreo.setFont(new java.awt.Font("DialogInput", 0, 15)); // NOI18N
        lblCorreo.setText("Correo");

        pwContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwContraseniaActionPerformed(evt);
            }
        });

        pwVerificacionContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwVerificacionContraseniaActionPerformed(evt);
            }
        });

        lblContrasenia.setFont(new java.awt.Font("DialogInput", 0, 15)); // NOI18N
        lblContrasenia.setText("Contraseña:");

        lblVerificacionContrasenia.setFont(new java.awt.Font("DialogInput", 0, 15)); // NOI18N
        lblVerificacionContrasenia.setText("Verifique su contraseña:");

        lblRegistro.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        lblRegistro.setText("REGISTRO");

        btnAceptar.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                        .addComponent(lblRegistro)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblContrasenia)
                            .addComponent(lblVerificacionContrasenia)
                            .addComponent(txtNombre)
                            .addComponent(txtCorreo)
                            .addComponent(pwContrasenia)
                            .addComponent(pwVerificacionContrasenia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblNombre))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblRegistro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContrasenia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pwContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblVerificacionContrasenia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwVerificacionContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pwVerificacionContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwVerificacionContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwVerificacionContraseniaActionPerformed

    private void pwContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwContraseniaActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    if (validarCamposVacios()) {
        return; // Si hay campos vacíos, salimos del método
    }
    
    if (!validarFormatoCorreo()) {
        return;
    }
    
    if (!validarRequisitosContrasenia()) {
        return;
        
}
    if (!validarContrasenias()) {
        return;
    }
    
    try{
      
        String contrasenia = new String(pwContrasenia.getPassword());
        String contraseniaEncriptada = encriptar(contrasenia);
        
        
        Colaborador c = new Colaborador();
        c.setNombre(txtNombre.getText());
        c.setCorreo(txtCorreo.getText());
        c.setContrasenia(contraseniaEncriptada);
        
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        colaboradorDAO.crearColaborador(c);
        
        JOptionPane.showMessageDialog(this, 
            "Registro exitoso!", 
            "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);
        this.dispose(); 
        
    }catch(Exception err){
        System.err.println("Ocurrió un error durante el registro "+err.getMessage());
    }
    
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistroDialog dialog = new RegistroDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblVerificacionContrasenia;
    private javax.swing.JPasswordField pwContrasenia;
    private javax.swing.JPasswordField pwVerificacionContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
