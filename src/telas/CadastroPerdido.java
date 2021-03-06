/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.Local;
import classes.Publicacao;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel
 */
public class CadastroPerdido extends javax.swing.JFrame {

    File f;
    BufferedImage img;
    Image newimg;
    ImageIcon icone;

    public CadastroPerdido() {
        URL url = this.getClass().getResource("/images/logo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLLogo = new javax.swing.JLabel();
        bemVindo = new javax.swing.JLabel();
        jLADMNome = new javax.swing.JLabel();
        JLLogoutIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanelContent = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jButtonCadastroUsuario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonAtualizarUsuario = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButtonExcluirUsuario = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButtonVisualizarUsuario = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButtonNovoEncontrado = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonNovoPerdido = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelEncontrados = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLNome = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        jTData = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelAlunoServidor = new javax.swing.JLabel();
        jComboBoxLocal = new javax.swing.JComboBox<>();
        jButtonAceitarEncontrado1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jTFuncao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDescricao = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jTTitulo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jBSelecionar = new javax.swing.JButton();
        jLVisualizacaoImagem = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(127, 0, 0));

        jLLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        bemVindo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bemVindo.setForeground(new java.awt.Color(255, 255, 255));
        bemVindo.setText("Bem vindo(a), ");

        jLADMNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLADMNome.setForeground(new java.awt.Color(255, 255, 255));

        JLLogoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sair");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bemVindo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLLogoutIcon)
                    .addComponent(jLabel1)
                    .addComponent(jLADMNome, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bemVindo)
                            .addComponent(jLADMNome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(JLLogoutIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jLLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanelContent.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(245, 245, 245));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(123, 8, 8));
        jLabel2.setText("CADASTRAR USUARIO");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userAdd.png"))); // NOI18N

        javax.swing.GroupLayout jButtonCadastroUsuarioLayout = new javax.swing.GroupLayout(jButtonCadastroUsuario);
        jButtonCadastroUsuario.setLayout(jButtonCadastroUsuarioLayout);
        jButtonCadastroUsuarioLayout.setHorizontalGroup(
            jButtonCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonCadastroUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jButtonCadastroUsuarioLayout.setVerticalGroup(
            jButtonCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonCadastroUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(123, 8, 8));
        jLabel4.setText("ATUALIZAR USUARIO");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updateUser.png"))); // NOI18N

        javax.swing.GroupLayout jButtonAtualizarUsuarioLayout = new javax.swing.GroupLayout(jButtonAtualizarUsuario);
        jButtonAtualizarUsuario.setLayout(jButtonAtualizarUsuarioLayout);
        jButtonAtualizarUsuarioLayout.setHorizontalGroup(
            jButtonAtualizarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonAtualizarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );
        jButtonAtualizarUsuarioLayout.setVerticalGroup(
            jButtonAtualizarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonAtualizarUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(123, 8, 8));
        jLabel16.setText("EXCLUIR USUARIO");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userAdd.png"))); // NOI18N

        javax.swing.GroupLayout jButtonExcluirUsuarioLayout = new javax.swing.GroupLayout(jButtonExcluirUsuario);
        jButtonExcluirUsuario.setLayout(jButtonExcluirUsuarioLayout);
        jButtonExcluirUsuarioLayout.setHorizontalGroup(
            jButtonExcluirUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonExcluirUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addContainerGap())
        );
        jButtonExcluirUsuarioLayout.setVerticalGroup(
            jButtonExcluirUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonExcluirUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(123, 8, 8));
        jLabel14.setText("VISUALIZAR USUARIOS");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updateUser.png"))); // NOI18N

        javax.swing.GroupLayout jButtonVisualizarUsuarioLayout = new javax.swing.GroupLayout(jButtonVisualizarUsuario);
        jButtonVisualizarUsuario.setLayout(jButtonVisualizarUsuarioLayout);
        jButtonVisualizarUsuarioLayout.setHorizontalGroup(
            jButtonVisualizarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonVisualizarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );
        jButtonVisualizarUsuarioLayout.setVerticalGroup(
            jButtonVisualizarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonVisualizarUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(123, 8, 8));
        jLabel5.setText("NOVO ENCONTRADO");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N

        javax.swing.GroupLayout jButtonNovoEncontradoLayout = new javax.swing.GroupLayout(jButtonNovoEncontrado);
        jButtonNovoEncontrado.setLayout(jButtonNovoEncontradoLayout);
        jButtonNovoEncontradoLayout.setHorizontalGroup(
            jButtonNovoEncontradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonNovoEncontradoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonNovoEncontradoLayout.setVerticalGroup(
            jButtonNovoEncontradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonNovoEncontradoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(123, 8, 8));
        jLabel12.setText("NOVO PERDIDO");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N

        javax.swing.GroupLayout jButtonNovoPerdidoLayout = new javax.swing.GroupLayout(jButtonNovoPerdido);
        jButtonNovoPerdido.setLayout(jButtonNovoPerdidoLayout);
        jButtonNovoPerdidoLayout.setHorizontalGroup(
            jButtonNovoPerdidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonNovoPerdidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jButtonNovoPerdidoLayout.setVerticalGroup(
            jButtonNovoPerdidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonNovoPerdidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonNovoEncontrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonNovoPerdido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonExcluirUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonVisualizarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jButtonCadastroUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAtualizarUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addComponent(jButtonCadastroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAtualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExcluirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVisualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNovoEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNovoPerdido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 340, Short.MAX_VALUE))
        );

        jPanelContent.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1116, 0, -1, 592));

        jPanelEncontrados.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEncontrados.setMaximumSize(new java.awt.Dimension(515, 500));
        jPanelEncontrados.setMinimumSize(new java.awt.Dimension(515, 500));
        jPanelEncontrados.setLayout(new java.awt.GridLayout(4, 1));
        jPanelContent.add(jPanelEncontrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 62, -1, 500));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(128, 0, 0));
        jLabel20.setText("Cadastro de objeto perdido");
        jPanelContent.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));
        jPanelContent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 46, 1050, 15));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 0, 0));
        jLabel7.setText("Selecione o local onde foi visto pela última vez:");
        jPanelContent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 320, -1));

        jLNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLNome.setForeground(new java.awt.Color(128, 0, 0));
        jLNome.setText("Título:");
        jPanelContent.add(jLNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 240, -1));

        jLEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLEmail.setForeground(new java.awt.Color(128, 0, 0));
        jLEmail.setText("Descrição:");
        jPanelContent.add(jLEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 190, -1));

        jTData.setForeground(new java.awt.Color(128, 0, 0));
        jTData.setBorder(null);
        jTData.setSelectionColor(new java.awt.Color(255, 51, 51));
        jPanelContent.add(jTData, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 314, 540, 20));
        jPanelContent.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 240, 20));
        jPanelContent.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 540, 20));

        jLabelAlunoServidor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelAlunoServidor.setForeground(new java.awt.Color(128, 0, 0));
        jLabelAlunoServidor.setText("Data aproximada ou exata em que foi perdido:");
        jPanelContent.add(jLabelAlunoServidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 380, -1));

        jComboBoxLocal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelContent.add(jComboBoxLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 320, -1));

        jButtonAceitarEncontrado1.setBackground(new java.awt.Color(92, 184, 92));
        jButtonAceitarEncontrado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAceitarEncontrado1MouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("CONFIRMAR");

        javax.swing.GroupLayout jButtonAceitarEncontrado1Layout = new javax.swing.GroupLayout(jButtonAceitarEncontrado1);
        jButtonAceitarEncontrado1.setLayout(jButtonAceitarEncontrado1Layout);
        jButtonAceitarEncontrado1Layout.setHorizontalGroup(
            jButtonAceitarEncontrado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonAceitarEncontrado1Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jButtonAceitarEncontrado1Layout.setVerticalGroup(
            jButtonAceitarEncontrado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelContent.add(jButtonAceitarEncontrado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 530, 250, -1));

        jTFuncao.setForeground(new java.awt.Color(128, 0, 0));
        jTFuncao.setBorder(null);
        jTFuncao.setSelectionColor(new java.awt.Color(255, 51, 51));
        jPanelContent.add(jTFuncao, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 540, -1));

        jTDescricao.setColumns(20);
        jTDescricao.setRows(5);
        jScrollPane1.setViewportView(jTDescricao);

        jPanelContent.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 540, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(128, 0, 0));
        jLabel10.setText("Imagem selecionada:");
        jPanelContent.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 200, -1));

        jTTitulo.setForeground(new java.awt.Color(128, 0, 0));
        jTTitulo.setBorder(null);
        jTTitulo.setSelectionColor(new java.awt.Color(255, 51, 51));
        jPanelContent.add(jTTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 540, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanelContent.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jBSelecionar.setText("Selecionar");
        jBSelecionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBSelecionarMouseClicked(evt);
            }
        });
        jPanelContent.add(jBSelecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, -1, -1));
        jPanelContent.add(jLVisualizacaoImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 70, 60));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(128, 0, 0));
        jLabel11.setText("Se desejar, inclua uma foto:");
        jPanelContent.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1378, 839));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            Cliente.out.writeObject("fim");
        } catch (IOException ex) {
            Logger.getLogger(CadastroPerdido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jLADMNome.setText(Cliente.ServidorLogado.getNome());
        jLabel10.setVisible(false);
        try {
            Local l;
            Cliente.out.writeObject("listaLocais");
            String resposta = (String) Cliente.in.readObject();
            if (resposta.equals("ok")) {
                System.out.println("Recebeu o primeiro ok");
                Cliente.out.writeObject("ok");
                System.out.println("Enviou o ok");
                ArrayList<classes.Local> listaLocais = new ArrayList();
                listaLocais = (ArrayList) Cliente.in.readObject();
                System.out.println("recebeu a lista");
                if (!listaLocais.isEmpty()) {
                    for (int i = 0; i < listaLocais.size(); i++) {
                        l = listaLocais.get(i);
                        System.out.println("Pegou um local:" + l.getNome());
                        jComboBoxLocal.addItem(l.getNome());
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CadastroPerdido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroPerdido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButtonAceitarEncontrado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceitarEncontrado1MouseClicked

        String titulo;
        String descricao;
//        String data;
        int id_local = jComboBoxLocal.getSelectedIndex();

        titulo = jTTitulo.getText();
        descricao = jTDescricao.getText();
        String dataString = jTData.getText();
        int status = 1;
        int tipo = 1;
        int situacao = 0;

        Publicacao p = new Publicacao(titulo, descricao, dataString, status, tipo, situacao);
        p.setArquivo(f);

        p.setUsuario_origem(Cliente.ServidorLogado.getId_usuario());
        try {
            Cliente.out.writeObject("cadastroPublicacao");
            String resposta = (String) Cliente.in.readObject();
            if (resposta.equals("ok")) {
                Cliente.out.writeObject(p);
                resposta = (String) Cliente.in.readObject();
                if (resposta.equals("ok")) {
                    Cliente.out.writeObject(id_local);
                    resposta = (String) Cliente.in.readObject();
                    if (resposta.equals("ok")) {
                        JOptionPane.showMessageDialog(jPanelContent, "Objeto postado");
                    } else if (resposta.equals("erro")) {
                        JOptionPane.showMessageDialog(jPanelContent, "Ocorreu um erro");

                    }
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(CadastroPerdido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroPerdido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonAceitarEncontrado1MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        
        dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jBSelecionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSelecionarMouseClicked
        JFileChooser selecionar = new JFileChooser();
        selecionar.showOpenDialog(null);
        f = selecionar.getSelectedFile();
        File arquivo = new File("caminho para o arquivo");;

        File[] arquivos = arquivo.listFiles(
                new FilenameFilter() {
            public boolean accept(final File pasta, final String nome) {
                return nome.toLowerCase().matches(".*\\\\.(png)$");
            }
            ;
        int i;
        });
        try {
            img = ImageIO.read(f);
        } catch (IOException ex) {
            Logger.getLogger(CadastroPerdido.class.getName()).log(Level.SEVERE, null, ex);
        }
        newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        icone = new ImageIcon(newimg);
        jLabel10.setVisible(true);
        jLVisualizacaoImagem.setIcon(icone);
    }//GEN-LAST:event_jBSelecionarMouseClicked

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
            java.util.logging.Logger.getLogger(CadastroPerdido.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPerdido.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPerdido.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPerdido.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPerdido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLLogoutIcon;
    private javax.swing.JLabel bemVindo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBSelecionar;
    private javax.swing.JPanel jButtonAceitarEncontrado1;
    private javax.swing.JPanel jButtonAtualizarUsuario;
    private javax.swing.JPanel jButtonCadastroUsuario;
    private javax.swing.JPanel jButtonExcluirUsuario;
    private javax.swing.JPanel jButtonNovoEncontrado;
    private javax.swing.JPanel jButtonNovoPerdido;
    private javax.swing.JPanel jButtonVisualizarUsuario;
    private javax.swing.JComboBox<String> jComboBoxLocal;
    private javax.swing.JLabel jLADMNome;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLVisualizacaoImagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAlunoServidor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelEncontrados;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTData;
    private javax.swing.JTextArea jTDescricao;
    private javax.swing.JTextField jTFuncao;
    private javax.swing.JTextField jTTitulo;
    // End of variables declaration//GEN-END:variables
}
