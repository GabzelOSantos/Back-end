package view;

import cadastro.Cadastro;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class View extends JFrame{
    public void newFrame(){
        Cadastro newUser = new Cadastro();

        JFrame frame = new JFrame("Login");

        ArrayList<Cadastro> users = new ArrayList<>();

        int frameW = 640;
        int frameH = 480;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameW, frameH);
        frame.setLayout(null);

        //Login

        JLabel emailLabel = new JLabel("Insira seu E-mail");
        JLabel passwordLabel = new JLabel("Insira sua senha");

        emailLabel.setBounds(10, 0, 200, 200);
        passwordLabel.setBounds(10, 80, 200, 200);

        JTextField emailText = new JTextField();
        JTextField passwordText = new JTextField();

        emailText.setBounds(10, 120, 200, 30);
        passwordText.setBounds(10,200, 200, 30);

        JButton loginButton = new JButton("Realizar Log-in");
        JButton clearButton = new JButton("Apagar campos");

        loginButton.setBounds(10, 300, 200, 50);
        clearButton.setBounds(10, 360, 200, 50);

        frame.add(emailLabel);
        frame.add(passwordLabel);

        frame.add(emailText);
        frame.add(passwordText);

        frame.add(loginButton);
        frame.add(clearButton);

        // Cadastro

        JLabel emailCadastroLabel = new JLabel("Insira seu E-mail");
        JLabel passwordCadastroLabel = new JLabel("Crie sua senha");

        emailCadastroLabel.setBounds(260, 0, 200, 200);
        passwordCadastroLabel.setBounds(260, 80, 200, 200);

        JTextField emailCadastroText = new JTextField();
        JTextField passwordCadastroText = new JTextField();

        emailCadastroText.setBounds(260, 120, 200, 30);
        passwordCadastroText.setBounds(260,200, 200, 30);

        JButton createButton = new JButton("Criar conta");
        JButton viewButton = new JButton("Ver contas cadastradas");

        createButton.setBounds(260, 300, 200, 50);
        viewButton.setBounds(260, 360, 200, 50);

        frame.add(emailCadastroLabel);
        frame.add(passwordCadastroLabel);

        frame.add(emailCadastroText);
        frame.add(passwordCadastroText);

        frame.add(createButton);
        frame.add(viewButton);

        JLabel deleteLabel = new JLabel("Insira o id");

        JTextField idText = new JTextField();

        deleteLabel.setBounds(500, 0, 200, 200);
        idText.setBounds(500, 120, 200, 30);

        JButton deleteButton =  new JButton("Deletar cadastro");
        deleteButton.setBounds(500, 300, 200, 50);

        frame.add(deleteLabel);
        frame.add(idText);
        frame.add(deleteButton);

        loginButton.addActionListener(e -> {
            String email = emailText.getText();
            String password = passwordText.getText();

            boolean verified = false;

            for (Cadastro user : users){
                if (user.getEmail().equals(email) && user.getSenha().equals(password)) {
                    verified = true;
                    break;
                }
            }

            if (verified == true){
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                verified = false;
            }else{
                JOptionPane.showMessageDialog(null, "Credenciais inválidas, tente novamente.");
            }
        });

        clearButton.addActionListener(e -> {
            emailText.setText(null);
            passwordText.setText(null);
        });

        createButton.addActionListener(e -> {
            AtomicInteger id = new AtomicInteger();

            String email = emailCadastroText.getText();
            String password = passwordCadastroText.getText();

            newUser.setId(id.getAndIncrement());
            newUser.setEmail(email);
            newUser.setPassword(password);

            users.add(newUser);

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        });

        viewButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Usuários: \n\n"+users);
        });

        deleteButton.addActionListener(e -> {
            String id = idText.getText();
        });

        frame.setVisible(true);
    }
}
