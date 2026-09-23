/*Ejemplo 03******************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGrafico extends JFrame implements ActionListener {

    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JButton btnIngresar;

    private final String USUARIO_CORRECTO = "Tatiana";
    private final String CLAVE_CORRECTA = "1234";

    public LoginGrafico() {
        setTitle("Inicio de Sesión Seguro");
        setSize(380, 420); // Ventana más alta para dar espacio a los gráficos
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // El diseño principal distribuye los paneles por zonas (Norte, Centro, Sur)
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE); // Fondo blanco limpio

        // ===================================================
        // 1. PANEL SUPERIOR: IMAGEN PRINCIPAL (AVATAR)
        // ===================================================
        JPanel panelAvatar = new JPanel();
        panelAvatar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        panelAvatar.setBackground(Color.WHITE);

        try {
            ImageIcon imgOriginal = new ImageIcon("candado.png");
            // Redimensionamos la imagen a 100x100 de forma fluida por si es muy grande
            Image imgEscalada = imgOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            JLabel lblAvatar = new JLabel(new ImageIcon(imgEscalada));
            panelAvatar.add(lblAvatar);
        } catch (Exception e) {
            panelAvatar.add(new JLabel("[Imagen: candado.png]"));
        }

        // ===================================================
        // 2. PANEL CENTRAL: FORMULARIO CON ÍCONOS
        // ===================================================
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(3, 2, 10, 15));
        panelFormulario.setBackground(Color.WHITE);
        // Añadimos márgenes internos alrededor del formulario (Arriba, Izquierda, Abajo, Derecha)
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        // --- Campo Usuario ---
        JLabel lblUsuario = new JLabel(" Usuario:");
        try {
            ImageIcon icoUser = new ImageIcon("user_icon.png");
            Image icoUserEscalado = icoUser.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            lblUsuario.setIcon(new ImageIcon(icoUserEscalado)); // Añade el ícono al texto del JLabel
        } catch (Exception e) { System.out.println("No se encontró user_icon.png"); }

        txtUsuario = new JTextField();
        panelFormulario.add(lblUsuario);
        panelFormulario.add(txtUsuario);

        // --- Campo Contraseña ---
        JLabel lblClave = new JLabel(" Contraseña:");
        try {
            ImageIcon icoLock = new ImageIcon("lock_icon.png");
            Image icoLockEscalado = icoLock.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            lblClave.setIcon(new ImageIcon(icoLockEscalado)); // Añade el ícono al texto del JLabel
        } catch (Exception e) { System.out.println("No se encontró lock_icon.png"); }

        txtClave = new JPasswordField();
        panelFormulario.add(lblClave);
        panelFormulario.add(txtClave);

        // --- Botón Ingresar ---
        panelFormulario.add(new JLabel("")); // Espacio vacío para alinear el botón a la derecha
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 14));
        btnIngresar.setBackground(new Color(41, 128, 185)); // Azul elegante
        btnIngresar.setForeground(Color.WHITE); // Texto blanco
        btnIngresar.setFocusPainted(false);
        btnIngresar.addActionListener(this);
        panelFormulario.add(btnIngresar);

        // ===================================================
        // CONSTRUCCIÓN DE LA VENTANA
        // ===================================================
        add(panelAvatar, BorderLayout.NORTH);
        add(panelFormulario, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIngresar) {
            String usuario = txtUsuario.getText();
            String clave = new String(txtClave.getPassword());

            if (usuario.equals(USUARIO_CORRECTO) && clave.equals(CLAVE_CORRECTA)) {
                JOptionPane.showMessageDialog(this, "¡Acceso Concedido! Bienvenido.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginGrafico ventana = new LoginGrafico();
            ventana.setVisible(true);
        });
    }
}

 