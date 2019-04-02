/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.Aluno;
import classes.Publicacao;
import classes.Servidor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel
 */
public class Home extends javax.swing.JFrame {

    LinkedList<Publicacao> listaEncontrados = new LinkedList<Publicacao>();
    LinkedList<Publicacao> listaPerdidos = new LinkedList<Publicacao>();
    int idE1 = -1;
    int idE2 = -1;
    int idE3 = -1;
    int idE4 = -1;

    int idP1 = -1;
    int idP2 = -1;
    int idP3 = -1;
    int idP4 = -1;

    public Home(Servidor s) {
        URL url = this.getClass().getResource("/images/LOGO_2.5.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        initComponents();
        jLADMNome.setText(s.getNome());

    }

    Home() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizaInterface() {
        //-------------montagem dos objetos encontrados ------------
        System.out.println("Atualizando interface");
        classes.Publicacao p1;
        BufferedImage img;
        Image newimg;
        ImageIcon icone;
        boolean buscar = true;
        try {
            Cliente.out.writeObject("listaEncontrados");
            String result = (String) Cliente.in.readObject();
            if (result.equals("ok")) {
                Cliente.out.writeObject("pendentes");
                listaEncontrados = (LinkedList) Cliente.in.readObject();
                int quantidade_publicacoes_encontrados = listaEncontrados.size();
                int qt = 0;
                System.out.println("tamanho da lista de encontrados: " + listaEncontrados.size());
                if (listaPerdidos.size() > 0) {
                    try {
                        System.out.println("Criando primeiro card de encontrado");
                        p1 = listaEncontrados.get(0);
                        jLabelTituloEncontrado1.setText(p1.getTitulo());
                        jLabelDescricaoEncontrado1.setText(p1.getDescricao());
                        //lasses.Local = p1.getLocal();
                        jLabelLocalEncontrado1.setText(p1.getLocalLiteral());
                        try {
                            Cliente.out.writeObject("buscaNomeUsuario");
                            String r = (String) Cliente.in.readObject();
                            Cliente.out.writeObject(p1.getUsuario_origem());
                            String nomeUsuario = (String) Cliente.in.readObject();
                            jLabelAutorEncontrado1.setText(nomeUsuario);

                        } catch (ClassNotFoundException ex) {
                            System.out.println("erro buscando nome");
                        }
                        idE1 = p1.getId_publicacao();
                        try {
                            img = ImageIO.read(p1.getArquivo());
                            newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                            icone = new ImageIcon(newimg);
                            jLabelFotoEncontrado1.setIcon(icone);
                        } catch (IOException ex) {
                            System.out.println("Erro buscando imagem: " + ex);
                        }

                        qt++;

                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Fim da lista no primeiro item encontrado. Erro: " + ex);
                        disableComponents(1);
                    }
                    try {
                        System.out.println("Criando segundo card de encontrado");
                        classes.Publicacao p2 = listaEncontrados.get(1);
                        jLabelTituloEncontrado2.setText(p2.getTitulo());
                        jLabelDescricaoEncontrado2.setText(p2.getDescricao());
                        //classes.Local l2 = p2.getLocal();
                        jLabelLocalEncontrado2.setText(p2.getLocalLiteral());
                        try {
                            Cliente.out.writeObject("buscaNomeUsuario");
                            String r = (String) Cliente.in.readObject();
                            Cliente.out.writeObject(p2.getUsuario_origem());
                            String nomeUsuario = (String) Cliente.in.readObject();
                            jLabelAutorEncontrado2.setText(nomeUsuario);

                        } catch (ClassNotFoundException ex) {
                            System.out.println("erro buscando nome");
                        }

                        idE2 = p2.getId_publicacao();
                        try {
                            img = ImageIO.read(p2.getArquivo());
                            newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                            icone = new ImageIcon(newimg);
                            jLabelFotoEncontrado2.setIcon(icone);
                        } catch (IOException ex) {

                        }
                        qt++;
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Fim da lista no elemento 1 encontrado.");
                        disableComponents(2);
                    }
                    try {
                        System.out.println("Criando terceiro card de encontrado");
                        classes.Publicacao p3 = listaEncontrados.get(2);
                        jLabelTituloEncontrado3.setText(p3.getTitulo());
                        jLabelDescricaoEncontrado3.setText(p3.getDescricao());
                        //classes.Local l3 = p3.getLocal();
                        jLabelLocalEncontrado3.setText(p3.getLocalLiteral());
                        try {
                            Cliente.out.writeObject("buscaNomeUsuario");
                            String r = (String) Cliente.in.readObject();
                            Cliente.out.writeObject(p3.getUsuario_origem());
                            String nomeUsuario = (String) Cliente.in.readObject();
                            jLabelAutorEncontrado3.setText(nomeUsuario);

                        } catch (ClassNotFoundException ex) {
                            System.out.println("erro buscando nome");
                        }
                        idE3 = p3.getId_publicacao();
                        img = ImageIO.read(p3.getArquivo());
                        newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                        icone = new ImageIcon(newimg);
                        jLabelFotoEncontrado3.setIcon(icone);
                        qt++;

                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Fim da lista no elemento 2 encontrado");
                        disableComponents(3);

                    } catch (IOException ex) {
                        System.out.println("Erro de leitura: " + ex);
                    }

                    try {
                        System.out.println("Criando quarto card de encontrado");
                        classes.Publicacao p4 = listaEncontrados.get(3);
                        jLabelTituloEncontrado4.setText(p4.getTitulo());
                        jLabelDescricaoEncontrado4.setText(p4.getDescricao());
                        //classes.Local l4 = p4.getLocal();
                        jLabelLocalEncontrado4.setText(p4.getLocalLiteral());
                        try {
                            Cliente.out.writeObject("buscaNomeUsuario");
                            String r = (String) Cliente.in.readObject();
                            Cliente.out.writeObject(p4.getUsuario_origem());
                            String nomeUsuario = (String) Cliente.in.readObject();
                            jLabelAutorEncontrado4.setText(nomeUsuario);

                        } catch (ClassNotFoundException ex) {
                            System.out.println("erro buscando nome");
                        }
                        idE4 = p4.getId_publicacao();
                        img = ImageIO.read(p4.getArquivo());
                        newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                        icone = new ImageIcon(newimg);
                        jLabelFotoEncontrado4.setIcon(icone);
                        qt++;
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Fim da lista no elemento 3 encontrado");
                        disableComponents(4);
                    }
                    jLQuantidadeEncontrados.setText("Exibindo " + qt + " de " + listaEncontrados.size() + " itens");

                } else {
                    for (int x = 1; x <= 4; x++) { //retira todos os componentes da tela caso a lista esteja vazia
                        disableComponents(x);
                    }
                }

            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: " + ex);
        } catch (IOException ex) {
            System.out.println("Entrou no catch");
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);

        }

        //--------------- MONTAGEM DOS OBJETOS PERDIDOS ---------------
        try {
            Cliente.out.writeObject("listaPerdidos");
            String result = (String) Cliente.in.readObject();
            if (result.equals("ok")) {
                Cliente.out.writeObject("pendentes");
                listaPerdidos = (LinkedList) Cliente.in.readObject();
                int quantidade_publicacoes_perdidos = listaPerdidos.size();
                int qt2 = 0;

                System.out.println("tamanho da lista: " + listaPerdidos.size());
                if (listaPerdidos.size() > 0) { //testa se o tamanho da lista é maior que 0, antes testava se era null
                    try {
                        System.out.println("Criando primeiro card de perdido");
                        classes.Publicacao pp1 = listaPerdidos.get(0);
                        jLabelTituloPerdido1.setText(pp1.getTitulo());
                        jLabelDescricaoPerdido1.setText(pp1.getDescricao());
                        //lasses.Local = p1.getLocal();
                        jLabelLocalPerdido1.setText(pp1.getLocalLiteral());
                        try {
                            Cliente.out.writeObject("buscaNomeUsuario");
                            String r = (String) Cliente.in.readObject();
                            Cliente.out.writeObject(pp1.getUsuario_origem());
                            String nomeUsuario = (String) Cliente.in.readObject();
                            jLabelAutorPerdido1.setText(nomeUsuario);

                        } catch (ClassNotFoundException ex) {
                            System.out.println("erro buscando nome");
                        }
                        idP1 = pp1.getId_publicacao();
                        img = ImageIO.read(pp1.getArquivo());
                        newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                        icone = new ImageIcon(newimg);
                        jLabelFotoPerdido1.setIcon(icone);
                        qt2++;

                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Fim da lista no primeiro item perdido. Erro: " + ex);
                        disableComponents(5);
                    }
                    try {
                        System.out.println("Criando segundo card de perdido");
                        classes.Publicacao pp2 = listaPerdidos.get(1);
                        jLabelTituloPerdido2.setText(pp2.getTitulo());
                        jLabelDescricaoPerdido2.setText(pp2.getDescricao());
                        //classes.Local l2 = p2.getLocal();
                        jLabelLocalPerdido2.setText(pp2.getLocalLiteral());
                        try {
                            Cliente.out.writeObject("buscaNomeUsuario");
                            String r = (String) Cliente.in.readObject();
                            Cliente.out.writeObject(pp2.getUsuario_origem());
                            String nomeUsuario = (String) Cliente.in.readObject();
                            jLabelAutorPerdido2.setText(nomeUsuario);

                        } catch (ClassNotFoundException ex) {
                            System.out.println("erro buscando nome");
                        }
                        idP2 = pp2.getId_publicacao();
                        img = ImageIO.read(pp2.getArquivo());
                        newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                        icone = new ImageIcon(newimg);
                        jLabelFotoPerdido2.setIcon(icone);
                        qt2++;
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Fim da lista no elemento 1. perdido");
                        disableComponents(6);
                    }
                    try {

                        System.out.println("Criando terceiro card de perdido");
                        classes.Publicacao pp3 = listaPerdidos.get(2);
                        jLabelTituloPerdido3.setText(pp3.getTitulo());
                        jLabelDescricaoPerdido3.setText(pp3.getDescricao());
                        //classes.Local l3 = p3.getLocal();
                        jLabelLocalPerdido3.setText(pp3.getLocalLiteral());
                        try {
                            Cliente.out.writeObject("buscaNomeUsuario");
                            String r = (String) Cliente.in.readObject();
                            Cliente.out.writeObject(pp3.getUsuario_origem());
                            String nomeUsuario = (String) Cliente.in.readObject();
                            jLabelAutorPerdido3.setText(nomeUsuario);

                        } catch (ClassNotFoundException ex) {
                            System.out.println("erro buscando nome");
                        }
                        idP3 = pp3.getId_publicacao();
                        img = ImageIO.read(pp3.getArquivo());
                        newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                        icone = new ImageIcon(newimg);
                        jLabelFotoPerdido3.setIcon(icone);
                        qt2++;

                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Fim da lista no elemento 2 perdido");
                        disableComponents(7);
                    }
                    try {
                        System.out.println("Criando quarto card de perdido");
                        classes.Publicacao pp4 = listaPerdidos.get(3);
                        jLabelTituloPerdido4.setText(pp4.getTitulo());
                        jLabelDescricaoPerdido4.setText(pp4.getDescricao());
                        //classes.Local l4 = p4.getLocal();
                        jLabelLocalPerdido4.setText(pp4.getLocalLiteral());
                        try {
                            Cliente.out.writeObject("buscaNomeUsuario");
                            String r = (String) Cliente.in.readObject();
                            Cliente.out.writeObject(pp4.getUsuario_origem());
                            String nomeUsuario = (String) Cliente.in.readObject();
                            jLabelAutorPerdido4.setText(nomeUsuario);

                        } catch (ClassNotFoundException ex) {
                            System.out.println("erro buscando nome");
                        }
                        idP4 = pp4.getId_publicacao();
                        img = ImageIO.read(pp4.getArquivo());
                        newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                        icone = new ImageIcon(newimg);
                        jLabelFotoPerdido4.setIcon(icone);
                        qt2++;
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Fim da lista no elemento 3 perdido");
                        disableComponents(8);

                    }

                } else {
                    for (int x = 1; x <= 4; x++) { //retira todos os componentes da tela caso a lista esteja vazia
                        disableComponents(x);
                    }
                }
                jLPerdidosQuantidade.setText("Exibindo " + qt2 + " de " + listaPerdidos.size() + " itens");

            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: " + ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void aceitaPublicacao(int id) {
        System.out.println("Pegou o id: " + id);
        try {
            Cliente.out.writeObject("aceitaPublicacao");
            String mensagemRecebida = (String) Cliente.in.readObject();
            if (mensagemRecebida.equals("ok")) {
                Cliente.out.writeObject(id);
                mensagemRecebida = (String) Cliente.in.readObject();
                if (mensagemRecebida.equals("ok")) {
                    JOptionPane.showMessageDialog(jPanelContent, "Objeto postado.");
                    atualizaInterface();
                } else if (mensagemRecebida.equals("erro")) {
                    JOptionPane.showMessageDialog(jPanelContent, "Algo deu errado. Tente novamente");
                }

            }

        } catch (ClassNotFoundException ex) {

        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rejeitaPublicacao(int id) {
        System.out.println("Pegou o id: " + id);
        try {
            Cliente.out.writeObject("rejeitaPublicacao");
            String mensagemRecebida = (String) Cliente.in.readObject();
            if (mensagemRecebida.equals("ok")) {
                Cliente.out.writeObject(id);
                mensagemRecebida = (String) Cliente.in.readObject();
                if (mensagemRecebida.equals("ok")) {
                    JOptionPane.showMessageDialog(jPanelContent, "Objeto excluido-.");
                    atualizaInterface();
                } else if (mensagemRecebida.equals("erro")) {
                    JOptionPane.showMessageDialog(jPanelContent, "Algo deu errado. Tente novamente");
                }

            }

        } catch (ClassNotFoundException ex) {

        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLLogo = new javax.swing.JLabel();
        bemVindo = new javax.swing.JLabel();
        jLADMNome = new javax.swing.JLabel();
        JLLogoutIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
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
        jPanelPerdidos = new javax.swing.JPanel();
        jPanelPerdido1 = new javax.swing.JPanel();
        jLabelFotoPerdido1 = new javax.swing.JLabel();
        jLabelTituloPerdido1 = new javax.swing.JLabel();
        jLabelLocalPerdido1 = new javax.swing.JLabel();
        jLabelAutorPerdido1 = new javax.swing.JLabel();
        jButtonAceitarPerdido1 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jButtonRejeitarPerdido1 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jLabelDescricaoPerdido1 = new javax.swing.JTextPane();
        jPanelPerdido2 = new javax.swing.JPanel();
        jLabelFotoPerdido2 = new javax.swing.JLabel();
        jLabelTituloPerdido2 = new javax.swing.JLabel();
        jLabelLocalPerdido2 = new javax.swing.JLabel();
        jLabelAutorPerdido2 = new javax.swing.JLabel();
        jButtonAceitarPerdido2 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jButtonRejeitarPerdido2 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jLabelDescricaoPerdido2 = new javax.swing.JTextPane();
        jPanelPerdido3 = new javax.swing.JPanel();
        jLabelFotoPerdido3 = new javax.swing.JLabel();
        jLabelTituloPerdido3 = new javax.swing.JLabel();
        jLabelLocalPerdido3 = new javax.swing.JLabel();
        jLabelAutorPerdido3 = new javax.swing.JLabel();
        jButtonAceitarPerdido3 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jButtonRejeitarPerdido3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jLabelDescricaoPerdido3 = new javax.swing.JTextPane();
        jPanelPerdido4 = new javax.swing.JPanel();
        jLabelFotoPerdido4 = new javax.swing.JLabel();
        jLabelTituloPerdido4 = new javax.swing.JLabel();
        jLabelLocalPerdido4 = new javax.swing.JLabel();
        jLabelAutorPerdido4 = new javax.swing.JLabel();
        jButtonAceitarPerdido4 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jButtonRejeitarPerdido4 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jLabelDescricaoPerdido4 = new javax.swing.JTextPane();
        jLabelFinal = new javax.swing.JLabel();
        jPanelEncontrados = new javax.swing.JPanel();
        jPanelEncontrado1 = new javax.swing.JPanel();
        jLabelFotoEncontrado1 = new javax.swing.JLabel();
        jLabelTituloEncontrado1 = new javax.swing.JLabel();
        jLabelLocalEncontrado1 = new javax.swing.JLabel();
        jLabelAutorEncontrado1 = new javax.swing.JLabel();
        jButtonRejeitarEncontrado1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButtonAceitarEncontrado1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabelDescricaoEncontrado1 = new javax.swing.JTextPane();
        jPanelEncontrado2 = new javax.swing.JPanel();
        jLabelFotoEncontrado2 = new javax.swing.JLabel();
        jLabelTituloEncontrado2 = new javax.swing.JLabel();
        jLabelLocalEncontrado2 = new javax.swing.JLabel();
        jLabelAutorEncontrado2 = new javax.swing.JLabel();
        jButtonAceitarEncontrado2 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jButtonRejeitarEncontrado22 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabelDescricaoEncontrado2 = new javax.swing.JTextPane();
        jPanelEncontrado3 = new javax.swing.JPanel();
        jLabelFotoEncontrado3 = new javax.swing.JLabel();
        jLabelTituloEncontrado3 = new javax.swing.JLabel();
        jLabelLocalEncontrado3 = new javax.swing.JLabel();
        jLabelAutorEncontrado3 = new javax.swing.JLabel();
        jButtonAceitarEncontrado3 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jButtonRejeitarEncontrado3 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabelDescricaoEncontrado3 = new javax.swing.JTextPane();
        jPanelEncontrado4 = new javax.swing.JPanel();
        jLabelFotoEncontrado4 = new javax.swing.JLabel();
        jLabelTituloEncontrado4 = new javax.swing.JLabel();
        jLabelLocalEncontrado4 = new javax.swing.JLabel();
        jLabelAutorEncontrado4 = new javax.swing.JLabel();
        jButtonAceitarEncontrado4 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jButtonRejeitarEncontrado4 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jLabelDescricaoEncontrado4 = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLQuantidadeEncontrados = new javax.swing.JLabel();
        jLPerdidosQuantidade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administração - iFound");
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

        jLabel18.setText("jLabel18");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Atualizar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bemVindo)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLLogoutIcon)
                                    .addComponent(jLabel1)
                                    .addComponent(jLADMNome, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(71, 71, 71))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bemVindo)
                            .addComponent(jLADMNome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(JLLogoutIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanelContent.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanelContentFocusGained(evt);
            }
        });

        jPanelMenu.setBackground(new java.awt.Color(245, 245, 245));

        jButtonCadastroUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCadastroUsuarioMouseClicked(evt);
            }
        });

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

        jButtonExcluirUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonExcluirUsuarioMouseClicked(evt);
            }
        });

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

        jButtonVisualizarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonVisualizarUsuarioMouseClicked(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jButtonNovoEncontrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNovoEncontradoMouseClicked(evt);
            }
        });

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

        jButtonNovoPerdido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNovoPerdidoMouseClicked(evt);
            }
        });

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
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonCadastroUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAtualizarUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGap(0, 305, Short.MAX_VALUE))
        );

        jPanelPerdidos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPerdidos.setMaximumSize(new java.awt.Dimension(515, 500));
        jPanelPerdidos.setLayout(new java.awt.GridLayout(4, 1));

        jPanelPerdido1.setBackground(new java.awt.Color(245, 245, 245));
        jPanelPerdido1.setMaximumSize(new java.awt.Dimension(515, 125));
        jPanelPerdido1.setMinimumSize(new java.awt.Dimension(515, 125));
        jPanelPerdido1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFotoPerdido1.setText("foto");
        jPanelPerdido1.add(jLabelFotoPerdido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 60, 51));

        jLabelTituloPerdido1.setText("Titulo");
        jPanelPerdido1.add(jLabelTituloPerdido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 11, -1, -1));

        jLabelLocalPerdido1.setText("local");
        jPanelPerdido1.add(jLabelLocalPerdido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 29, -1, -1));

        jLabelAutorPerdido1.setText("autor");
        jPanelPerdido1.add(jLabelAutorPerdido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jButtonAceitarPerdido1.setBackground(new java.awt.Color(92, 184, 92));
        jButtonAceitarPerdido1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAceitarPerdido1MouseClicked(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Aceitar");

        javax.swing.GroupLayout jButtonAceitarPerdido1Layout = new javax.swing.GroupLayout(jButtonAceitarPerdido1);
        jButtonAceitarPerdido1.setLayout(jButtonAceitarPerdido1Layout);
        jButtonAceitarPerdido1Layout.setHorizontalGroup(
            jButtonAceitarPerdido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonAceitarPerdido1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonAceitarPerdido1Layout.setVerticalGroup(
            jButtonAceitarPerdido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelPerdido1.add(jButtonAceitarPerdido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 80, -1, -1));

        jButtonRejeitarPerdido1.setBackground(new java.awt.Color(217, 83, 79));
        jButtonRejeitarPerdido1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRejeitarPerdido1MouseClicked(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Excluir");

        javax.swing.GroupLayout jButtonRejeitarPerdido1Layout = new javax.swing.GroupLayout(jButtonRejeitarPerdido1);
        jButtonRejeitarPerdido1.setLayout(jButtonRejeitarPerdido1Layout);
        jButtonRejeitarPerdido1Layout.setHorizontalGroup(
            jButtonRejeitarPerdido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonRejeitarPerdido1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonRejeitarPerdido1Layout.setVerticalGroup(
            jButtonRejeitarPerdido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelPerdido1.add(jButtonRejeitarPerdido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 80, -1, -1));

        jScrollPane5.setBorder(null);

        jLabelDescricaoPerdido1.setEditable(false);
        jLabelDescricaoPerdido1.setBackground(new java.awt.Color(245, 245, 245));
        jLabelDescricaoPerdido1.setBorder(null);
        jLabelDescricaoPerdido1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane5.setViewportView(jLabelDescricaoPerdido1);

        jPanelPerdido1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 51, 252, 63));

        jPanelPerdidos.add(jPanelPerdido1);

        jPanelPerdido2.setBackground(new java.awt.Color(248, 248, 248));
        jPanelPerdido2.setMaximumSize(new java.awt.Dimension(515, 125));
        jPanelPerdido2.setMinimumSize(new java.awt.Dimension(515, 125));
        jPanelPerdido2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFotoPerdido2.setText("foto");
        jPanelPerdido2.add(jLabelFotoPerdido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 60, 51));

        jLabelTituloPerdido2.setText("Titulo");
        jPanelPerdido2.add(jLabelTituloPerdido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 11, -1, -1));

        jLabelLocalPerdido2.setText("local");
        jPanelPerdido2.add(jLabelLocalPerdido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 29, -1, -1));

        jLabelAutorPerdido2.setText("autor");
        jPanelPerdido2.add(jLabelAutorPerdido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jButtonAceitarPerdido2.setBackground(new java.awt.Color(92, 184, 92));
        jButtonAceitarPerdido2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAceitarPerdido2MouseClicked(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Aceitar");

        javax.swing.GroupLayout jButtonAceitarPerdido2Layout = new javax.swing.GroupLayout(jButtonAceitarPerdido2);
        jButtonAceitarPerdido2.setLayout(jButtonAceitarPerdido2Layout);
        jButtonAceitarPerdido2Layout.setHorizontalGroup(
            jButtonAceitarPerdido2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonAceitarPerdido2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonAceitarPerdido2Layout.setVerticalGroup(
            jButtonAceitarPerdido2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelPerdido2.add(jButtonAceitarPerdido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 80, -1, -1));

        jButtonRejeitarPerdido2.setBackground(new java.awt.Color(217, 83, 79));
        jButtonRejeitarPerdido2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRejeitarPerdido2MouseClicked(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Excluir");

        javax.swing.GroupLayout jButtonRejeitarPerdido2Layout = new javax.swing.GroupLayout(jButtonRejeitarPerdido2);
        jButtonRejeitarPerdido2.setLayout(jButtonRejeitarPerdido2Layout);
        jButtonRejeitarPerdido2Layout.setHorizontalGroup(
            jButtonRejeitarPerdido2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonRejeitarPerdido2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jButtonRejeitarPerdido2Layout.setVerticalGroup(
            jButtonRejeitarPerdido2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelPerdido2.add(jButtonRejeitarPerdido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 80, -1, -1));

        jScrollPane6.setBorder(null);

        jLabelDescricaoPerdido2.setEditable(false);
        jLabelDescricaoPerdido2.setBackground(new java.awt.Color(248, 248, 248));
        jLabelDescricaoPerdido2.setBorder(null);
        jLabelDescricaoPerdido2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane6.setViewportView(jLabelDescricaoPerdido2);

        jPanelPerdido2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 51, 252, 63));

        jPanelPerdidos.add(jPanelPerdido2);

        jPanelPerdido3.setBackground(new java.awt.Color(245, 245, 245));
        jPanelPerdido3.setMaximumSize(new java.awt.Dimension(515, 125));
        jPanelPerdido3.setMinimumSize(new java.awt.Dimension(515, 125));
        jPanelPerdido3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFotoPerdido3.setText("foto");
        jPanelPerdido3.add(jLabelFotoPerdido3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 60, 51));

        jLabelTituloPerdido3.setText("Titulo");
        jPanelPerdido3.add(jLabelTituloPerdido3, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 11, -1, -1));

        jLabelLocalPerdido3.setText("local");
        jPanelPerdido3.add(jLabelLocalPerdido3, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 29, -1, -1));

        jLabelAutorPerdido3.setText("autor");
        jPanelPerdido3.add(jLabelAutorPerdido3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jButtonAceitarPerdido3.setBackground(new java.awt.Color(92, 184, 92));
        jButtonAceitarPerdido3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAceitarPerdido3MouseClicked(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Aceitar");

        javax.swing.GroupLayout jButtonAceitarPerdido3Layout = new javax.swing.GroupLayout(jButtonAceitarPerdido3);
        jButtonAceitarPerdido3.setLayout(jButtonAceitarPerdido3Layout);
        jButtonAceitarPerdido3Layout.setHorizontalGroup(
            jButtonAceitarPerdido3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonAceitarPerdido3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonAceitarPerdido3Layout.setVerticalGroup(
            jButtonAceitarPerdido3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelPerdido3.add(jButtonAceitarPerdido3, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 80, -1, -1));

        jButtonRejeitarPerdido3.setBackground(new java.awt.Color(217, 83, 79));
        jButtonRejeitarPerdido3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRejeitarPerdido3MouseClicked(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Excluir");

        javax.swing.GroupLayout jButtonRejeitarPerdido3Layout = new javax.swing.GroupLayout(jButtonRejeitarPerdido3);
        jButtonRejeitarPerdido3.setLayout(jButtonRejeitarPerdido3Layout);
        jButtonRejeitarPerdido3Layout.setHorizontalGroup(
            jButtonRejeitarPerdido3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonRejeitarPerdido3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonRejeitarPerdido3Layout.setVerticalGroup(
            jButtonRejeitarPerdido3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelPerdido3.add(jButtonRejeitarPerdido3, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 80, -1, -1));

        jScrollPane7.setBorder(null);

        jLabelDescricaoPerdido3.setEditable(false);
        jLabelDescricaoPerdido3.setBackground(new java.awt.Color(245, 245, 245));
        jLabelDescricaoPerdido3.setBorder(null);
        jLabelDescricaoPerdido3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane7.setViewportView(jLabelDescricaoPerdido3);

        jPanelPerdido3.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 51, 252, 63));

        jPanelPerdidos.add(jPanelPerdido3);

        jPanelPerdido4.setBackground(new java.awt.Color(248, 248, 248));
        jPanelPerdido4.setMaximumSize(new java.awt.Dimension(515, 125));
        jPanelPerdido4.setMinimumSize(new java.awt.Dimension(515, 125));
        jPanelPerdido4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFotoPerdido4.setText("foto");
        jPanelPerdido4.add(jLabelFotoPerdido4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 60, 51));

        jLabelTituloPerdido4.setText("Titulo");
        jPanelPerdido4.add(jLabelTituloPerdido4, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 11, -1, -1));

        jLabelLocalPerdido4.setText("local");
        jPanelPerdido4.add(jLabelLocalPerdido4, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 29, -1, -1));

        jLabelAutorPerdido4.setText("autor");
        jPanelPerdido4.add(jLabelAutorPerdido4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jButtonAceitarPerdido4.setBackground(new java.awt.Color(92, 184, 92));
        jButtonAceitarPerdido4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAceitarPerdido4MouseClicked(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Aceitar");

        javax.swing.GroupLayout jButtonAceitarPerdido4Layout = new javax.swing.GroupLayout(jButtonAceitarPerdido4);
        jButtonAceitarPerdido4.setLayout(jButtonAceitarPerdido4Layout);
        jButtonAceitarPerdido4Layout.setHorizontalGroup(
            jButtonAceitarPerdido4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonAceitarPerdido4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonAceitarPerdido4Layout.setVerticalGroup(
            jButtonAceitarPerdido4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelPerdido4.add(jButtonAceitarPerdido4, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 80, -1, -1));

        jButtonRejeitarPerdido4.setBackground(new java.awt.Color(217, 83, 79));
        jButtonRejeitarPerdido4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRejeitarPerdido4MouseClicked(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Excluir");

        javax.swing.GroupLayout jButtonRejeitarPerdido4Layout = new javax.swing.GroupLayout(jButtonRejeitarPerdido4);
        jButtonRejeitarPerdido4.setLayout(jButtonRejeitarPerdido4Layout);
        jButtonRejeitarPerdido4Layout.setHorizontalGroup(
            jButtonRejeitarPerdido4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonRejeitarPerdido4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonRejeitarPerdido4Layout.setVerticalGroup(
            jButtonRejeitarPerdido4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelPerdido4.add(jButtonRejeitarPerdido4, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 80, -1, -1));

        jScrollPane8.setBorder(null);

        jLabelDescricaoPerdido4.setEditable(false);
        jLabelDescricaoPerdido4.setBackground(new java.awt.Color(248, 248, 248));
        jLabelDescricaoPerdido4.setBorder(null);
        jLabelDescricaoPerdido4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane8.setViewportView(jLabelDescricaoPerdido4);

        jPanelPerdido4.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 51, 252, 63));

        jLabelFinal.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jPanelPerdido4.add(jLabelFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 260, 20));

        jPanelPerdidos.add(jPanelPerdido4);

        jPanelEncontrados.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEncontrados.setMaximumSize(new java.awt.Dimension(515, 500));
        jPanelEncontrados.setMinimumSize(new java.awt.Dimension(515, 500));
        jPanelEncontrados.setLayout(new java.awt.GridLayout(4, 1));

        jPanelEncontrado1.setBackground(new java.awt.Color(245, 245, 245));
        jPanelEncontrado1.setMaximumSize(new java.awt.Dimension(515, 125));
        jPanelEncontrado1.setMinimumSize(new java.awt.Dimension(515, 125));
        jPanelEncontrado1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelEncontrado1.add(jLabelFotoEncontrado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 60, 60));

        jLabelTituloEncontrado1.setText("Titulo");
        jPanelEncontrado1.add(jLabelTituloEncontrado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabelLocalEncontrado1.setText("local");
        jPanelEncontrado1.add(jLabelLocalEncontrado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabelAutorEncontrado1.setText("autor");
        jPanelEncontrado1.add(jLabelAutorEncontrado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, -1, 26));

        jButtonRejeitarEncontrado1.setBackground(new java.awt.Color(217, 83, 79));
        jButtonRejeitarEncontrado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRejeitarEncontrado1MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Excluir");

        javax.swing.GroupLayout jButtonRejeitarEncontrado1Layout = new javax.swing.GroupLayout(jButtonRejeitarEncontrado1);
        jButtonRejeitarEncontrado1.setLayout(jButtonRejeitarEncontrado1Layout);
        jButtonRejeitarEncontrado1Layout.setHorizontalGroup(
            jButtonRejeitarEncontrado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonRejeitarEncontrado1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonRejeitarEncontrado1Layout.setVerticalGroup(
            jButtonRejeitarEncontrado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelEncontrado1.add(jButtonRejeitarEncontrado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 80, -1, -1));

        jButtonAceitarEncontrado1.setBackground(new java.awt.Color(92, 184, 92));
        jButtonAceitarEncontrado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAceitarEncontrado1MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Aceitar");

        javax.swing.GroupLayout jButtonAceitarEncontrado1Layout = new javax.swing.GroupLayout(jButtonAceitarEncontrado1);
        jButtonAceitarEncontrado1.setLayout(jButtonAceitarEncontrado1Layout);
        jButtonAceitarEncontrado1Layout.setHorizontalGroup(
            jButtonAceitarEncontrado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonAceitarEncontrado1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonAceitarEncontrado1Layout.setVerticalGroup(
            jButtonAceitarEncontrado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelEncontrado1.add(jButtonAceitarEncontrado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 80, -1, -1));

        jScrollPane2.setBorder(null);

        jLabelDescricaoEncontrado1.setEditable(false);
        jLabelDescricaoEncontrado1.setBackground(new java.awt.Color(245, 245, 245));
        jLabelDescricaoEncontrado1.setBorder(null);
        jLabelDescricaoEncontrado1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane2.setViewportView(jLabelDescricaoEncontrado1);

        jPanelEncontrado1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 51, 252, 63));

        jPanelEncontrados.add(jPanelEncontrado1);

        jPanelEncontrado2.setBackground(new java.awt.Color(248, 248, 248));
        jPanelEncontrado2.setMaximumSize(new java.awt.Dimension(515, 125));
        jPanelEncontrado2.setMinimumSize(new java.awt.Dimension(515, 125));
        jPanelEncontrado2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFotoEncontrado2.setText("foto");
        jPanelEncontrado2.add(jLabelFotoEncontrado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 60, 51));

        jLabelTituloEncontrado2.setText("Titulo");
        jPanelEncontrado2.add(jLabelTituloEncontrado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabelLocalEncontrado2.setText("local");
        jPanelEncontrado2.add(jLabelLocalEncontrado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabelAutorEncontrado2.setText("autor");
        jPanelEncontrado2.add(jLabelAutorEncontrado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jButtonAceitarEncontrado2.setBackground(new java.awt.Color(92, 184, 92));
        jButtonAceitarEncontrado2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAceitarEncontrado2MouseClicked(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Aceitar");
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jButtonAceitarEncontrado2Layout = new javax.swing.GroupLayout(jButtonAceitarEncontrado2);
        jButtonAceitarEncontrado2.setLayout(jButtonAceitarEncontrado2Layout);
        jButtonAceitarEncontrado2Layout.setHorizontalGroup(
            jButtonAceitarEncontrado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonAceitarEncontrado2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonAceitarEncontrado2Layout.setVerticalGroup(
            jButtonAceitarEncontrado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelEncontrado2.add(jButtonAceitarEncontrado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 80, -1, -1));

        jButtonRejeitarEncontrado22.setBackground(new java.awt.Color(217, 83, 79));
        jButtonRejeitarEncontrado22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRejeitarEncontrado22MouseClicked(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Excluir");

        javax.swing.GroupLayout jButtonRejeitarEncontrado22Layout = new javax.swing.GroupLayout(jButtonRejeitarEncontrado22);
        jButtonRejeitarEncontrado22.setLayout(jButtonRejeitarEncontrado22Layout);
        jButtonRejeitarEncontrado22Layout.setHorizontalGroup(
            jButtonRejeitarEncontrado22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonRejeitarEncontrado22Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonRejeitarEncontrado22Layout.setVerticalGroup(
            jButtonRejeitarEncontrado22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelEncontrado2.add(jButtonRejeitarEncontrado22, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 80, -1, -1));

        jScrollPane1.setBorder(null);

        jLabelDescricaoEncontrado2.setEditable(false);
        jLabelDescricaoEncontrado2.setBackground(new java.awt.Color(248, 248, 248));
        jLabelDescricaoEncontrado2.setBorder(null);
        jLabelDescricaoEncontrado2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(jLabelDescricaoEncontrado2);

        jPanelEncontrado2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 51, 251, 63));

        jPanelEncontrados.add(jPanelEncontrado2);

        jPanelEncontrado3.setBackground(new java.awt.Color(245, 245, 245));
        jPanelEncontrado3.setMaximumSize(new java.awt.Dimension(515, 125));
        jPanelEncontrado3.setMinimumSize(new java.awt.Dimension(515, 125));
        jPanelEncontrado3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFotoEncontrado3.setText("foto");
        jPanelEncontrado3.add(jLabelFotoEncontrado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 60, 51));

        jLabelTituloEncontrado3.setText("Titulo");
        jPanelEncontrado3.add(jLabelTituloEncontrado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 11, -1, -1));

        jLabelLocalEncontrado3.setText("local");
        jPanelEncontrado3.add(jLabelLocalEncontrado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 29, -1, -1));

        jLabelAutorEncontrado3.setText("autor");
        jPanelEncontrado3.add(jLabelAutorEncontrado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jButtonAceitarEncontrado3.setBackground(new java.awt.Color(92, 184, 92));
        jButtonAceitarEncontrado3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAceitarEncontrado3MouseClicked(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Aceitar");

        javax.swing.GroupLayout jButtonAceitarEncontrado3Layout = new javax.swing.GroupLayout(jButtonAceitarEncontrado3);
        jButtonAceitarEncontrado3.setLayout(jButtonAceitarEncontrado3Layout);
        jButtonAceitarEncontrado3Layout.setHorizontalGroup(
            jButtonAceitarEncontrado3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonAceitarEncontrado3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonAceitarEncontrado3Layout.setVerticalGroup(
            jButtonAceitarEncontrado3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelEncontrado3.add(jButtonAceitarEncontrado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 80, -1, -1));

        jButtonRejeitarEncontrado3.setBackground(new java.awt.Color(217, 83, 79));
        jButtonRejeitarEncontrado3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRejeitarEncontrado3MouseClicked(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Excluir");

        javax.swing.GroupLayout jButtonRejeitarEncontrado3Layout = new javax.swing.GroupLayout(jButtonRejeitarEncontrado3);
        jButtonRejeitarEncontrado3.setLayout(jButtonRejeitarEncontrado3Layout);
        jButtonRejeitarEncontrado3Layout.setHorizontalGroup(
            jButtonRejeitarEncontrado3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonRejeitarEncontrado3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonRejeitarEncontrado3Layout.setVerticalGroup(
            jButtonRejeitarEncontrado3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelEncontrado3.add(jButtonRejeitarEncontrado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 80, -1, -1));

        jScrollPane3.setBorder(null);

        jLabelDescricaoEncontrado3.setEditable(false);
        jLabelDescricaoEncontrado3.setBackground(new java.awt.Color(245, 245, 245));
        jLabelDescricaoEncontrado3.setBorder(null);
        jLabelDescricaoEncontrado3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane3.setViewportView(jLabelDescricaoEncontrado3);

        jPanelEncontrado3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 51, 251, 63));

        jPanelEncontrados.add(jPanelEncontrado3);

        jPanelEncontrado4.setBackground(new java.awt.Color(248, 248, 248));
        jPanelEncontrado4.setMaximumSize(new java.awt.Dimension(515, 125));
        jPanelEncontrado4.setMinimumSize(new java.awt.Dimension(515, 125));
        jPanelEncontrado4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFotoEncontrado4.setText("foto");
        jPanelEncontrado4.add(jLabelFotoEncontrado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 60, 51));

        jLabelTituloEncontrado4.setText("Titulo");
        jPanelEncontrado4.add(jLabelTituloEncontrado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 11, -1, -1));

        jLabelLocalEncontrado4.setText("local");
        jPanelEncontrado4.add(jLabelLocalEncontrado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 29, -1, -1));

        jLabelAutorEncontrado4.setText("autor");
        jPanelEncontrado4.add(jLabelAutorEncontrado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jButtonAceitarEncontrado4.setBackground(new java.awt.Color(92, 184, 92));
        jButtonAceitarEncontrado4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAceitarEncontrado4MouseClicked(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Aceitar");

        javax.swing.GroupLayout jButtonAceitarEncontrado4Layout = new javax.swing.GroupLayout(jButtonAceitarEncontrado4);
        jButtonAceitarEncontrado4.setLayout(jButtonAceitarEncontrado4Layout);
        jButtonAceitarEncontrado4Layout.setHorizontalGroup(
            jButtonAceitarEncontrado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonAceitarEncontrado4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonAceitarEncontrado4Layout.setVerticalGroup(
            jButtonAceitarEncontrado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelEncontrado4.add(jButtonAceitarEncontrado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 80, -1, -1));

        jButtonRejeitarEncontrado4.setBackground(new java.awt.Color(217, 83, 79));
        jButtonRejeitarEncontrado4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRejeitarEncontrado4MouseClicked(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Excluir");

        javax.swing.GroupLayout jButtonRejeitarEncontrado4Layout = new javax.swing.GroupLayout(jButtonRejeitarEncontrado4);
        jButtonRejeitarEncontrado4.setLayout(jButtonRejeitarEncontrado4Layout);
        jButtonRejeitarEncontrado4Layout.setHorizontalGroup(
            jButtonRejeitarEncontrado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonRejeitarEncontrado4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonRejeitarEncontrado4Layout.setVerticalGroup(
            jButtonRejeitarEncontrado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelEncontrado4.add(jButtonRejeitarEncontrado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 80, -1, -1));

        jScrollPane4.setBorder(null);

        jLabelDescricaoEncontrado4.setEditable(false);
        jLabelDescricaoEncontrado4.setBackground(new java.awt.Color(248, 248, 248));
        jLabelDescricaoEncontrado4.setBorder(null);
        jLabelDescricaoEncontrado4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane4.setViewportView(jLabelDescricaoEncontrado4);

        jPanelEncontrado4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 51, 251, 63));

        jPanelEncontrados.add(jPanelEncontrado4);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(128, 0, 0));
        jLabel10.setText("Encontrados");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(128, 0, 0));
        jLabel11.setText("Perdidos");

        jLQuantidadeEncontrados.setText("a");

        jLPerdidosQuantidade.setText("a");

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentLayout.createSequentialGroup()
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanelEncontrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanelPerdidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLQuantidadeEncontrados, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLPerdidosQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLPerdidosQuantidade)
                            .addComponent(jLQuantidadeEncontrados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelEncontrados, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(jPanelPerdidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1378, 839));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            Cliente.out.writeObject("fim");
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        atualizaInterface();
    }//GEN-LAST:event_formWindowOpened

    private void jButtonCadastroUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCadastroUsuarioMouseClicked
        CadastroUsuario h = new CadastroUsuario();
        //h.setUndecorated(true);
        h.setVisible(true);

    }//GEN-LAST:event_jButtonCadastroUsuarioMouseClicked

    private void jButtonNovoEncontradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNovoEncontradoMouseClicked
        CadastroEncontrado c = new CadastroEncontrado();
        c.setVisible(true);

    }//GEN-LAST:event_jButtonNovoEncontradoMouseClicked

    private void jButtonNovoPerdidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNovoPerdidoMouseClicked
        CadastroPerdido c = new CadastroPerdido();
        c.setVisible(true);

    }//GEN-LAST:event_jButtonNovoPerdidoMouseClicked

    private void jButtonVisualizarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVisualizarUsuarioMouseClicked
        String pesquisa = JOptionPane.showInputDialog("Digite o email ou matricula do usuario: ");
        try {
            Cliente.out.writeObject("buscaUsuario");
            String mensagemRecebida = (String) Cliente.in.readObject();
            if (mensagemRecebida.equals("ok")) {
                System.out.println("Recebeu o ok");
                Cliente.out.writeObject(pesquisa);
                mensagemRecebida = (String) Cliente.in.readObject();
                if (mensagemRecebida.equals("ok aluno")) {
                    System.out.println("Vai receber um aluno");
                    Aluno a = (Aluno) Cliente.in.readObject();
                    VisualizacaoAluno v = new VisualizacaoAluno(a);
                    v.setVisible(true);
                } else if (mensagemRecebida.equals("ok servidor")) {
                    Servidor s = (Servidor) Cliente.in.readObject();
                    VisualizacaoServidor v = new VisualizacaoServidor(s);
                    v.setVisible(true);

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonVisualizarUsuarioMouseClicked

    private void jButtonAceitarEncontrado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceitarEncontrado1MouseClicked
        int id = idE1;
        aceitaPublicacao(id);
    }//GEN-LAST:event_jButtonAceitarEncontrado1MouseClicked

    private void jButtonAceitarPerdido1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceitarPerdido1MouseClicked
        int id = idP1;
        aceitaPublicacao(id);
    }//GEN-LAST:event_jButtonAceitarPerdido1MouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MouseClicked

    private void jButtonAceitarEncontrado2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceitarEncontrado2MouseClicked
        int id = idE2;
        aceitaPublicacao(id);
    }//GEN-LAST:event_jButtonAceitarEncontrado2MouseClicked

    private void jButtonAceitarEncontrado3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceitarEncontrado3MouseClicked
        int id = idE3;
        aceitaPublicacao(id);
    }//GEN-LAST:event_jButtonAceitarEncontrado3MouseClicked

    private void jButtonAceitarEncontrado4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceitarEncontrado4MouseClicked
        int id = idE4;
        aceitaPublicacao(id);
    }//GEN-LAST:event_jButtonAceitarEncontrado4MouseClicked

    private void jButtonAceitarPerdido2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceitarPerdido2MouseClicked
        int id = idP2;
        aceitaPublicacao(id);
    }//GEN-LAST:event_jButtonAceitarPerdido2MouseClicked

    private void jButtonAceitarPerdido3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceitarPerdido3MouseClicked
        int id = idP3;
        aceitaPublicacao(id);
    }//GEN-LAST:event_jButtonAceitarPerdido3MouseClicked

    private void jButtonAceitarPerdido4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceitarPerdido4MouseClicked
        int id = idP4;
        aceitaPublicacao(id);
    }//GEN-LAST:event_jButtonAceitarPerdido4MouseClicked

    private void jButtonRejeitarEncontrado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRejeitarEncontrado1MouseClicked
        int id = idE1;
        rejeitaPublicacao(id);
    }//GEN-LAST:event_jButtonRejeitarEncontrado1MouseClicked

    private void jButtonRejeitarEncontrado22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRejeitarEncontrado22MouseClicked
        int id = idE2;
        rejeitaPublicacao(id);
    }//GEN-LAST:event_jButtonRejeitarEncontrado22MouseClicked

    private void jButtonRejeitarEncontrado3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRejeitarEncontrado3MouseClicked
        int id = idE3;
        rejeitaPublicacao(id);
    }//GEN-LAST:event_jButtonRejeitarEncontrado3MouseClicked

    private void jButtonRejeitarPerdido2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRejeitarPerdido2MouseClicked
        int id = idP2;
        rejeitaPublicacao(id);
    }//GEN-LAST:event_jButtonRejeitarPerdido2MouseClicked

    private void jButtonExcluirUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExcluirUsuarioMouseClicked
        String pesquisa = JOptionPane.showInputDialog("Digite o email ou matricula do usuario: ");
        if (!pesquisa.equals("")) {
            try {
                Cliente.out.writeObject("excluirUsuario");
                System.out.println("Mando o excluir");
                String resposta = (String) Cliente.in.readObject();
                System.out.println("Lau a reposta");
                if (resposta.equals("ok")) {
                    System.out.println("Recebeu o ok");
                    Cliente.out.writeObject(pesquisa);
                    System.out.println("Enviou a pesquisa");
                    resposta = (String) Cliente.in.readObject();
                    if (resposta.equals("ok")) {
                        System.out.println("Recebeu ok");
                        JOptionPane.showMessageDialog(jPanelContent, "Usuario excluido");
                    } else if (resposta.equals("erro")) {
                        System.out.println("Recebeu erro");
                        JOptionPane.showMessageDialog(jPanelContent, "Deu errado");

                    }

                }
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButtonExcluirUsuarioMouseClicked

    private void jButtonRejeitarPerdido1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRejeitarPerdido1MouseClicked
        int id = idP1;
        rejeitaPublicacao(id);
    }//GEN-LAST:event_jButtonRejeitarPerdido1MouseClicked

    private void jButtonRejeitarPerdido3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRejeitarPerdido3MouseClicked
        int id = idP3;
        rejeitaPublicacao(id);
    }//GEN-LAST:event_jButtonRejeitarPerdido3MouseClicked

    private void jButtonRejeitarPerdido4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRejeitarPerdido4MouseClicked
        int id = idP4;
        rejeitaPublicacao(id);
    }//GEN-LAST:event_jButtonRejeitarPerdido4MouseClicked

    private void jButtonRejeitarEncontrado4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRejeitarEncontrado4MouseClicked
        int id = idE4;
        rejeitaPublicacao(id);
    }//GEN-LAST:event_jButtonRejeitarEncontrado4MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        atualizaInterface();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jPanelContentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanelContentFocusGained
        atualizaInterface();
    }//GEN-LAST:event_jPanelContentFocusGained

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLLogoutIcon;
    private javax.swing.JLabel bemVindo;
    private javax.swing.JPanel jButtonAceitarEncontrado1;
    private javax.swing.JPanel jButtonAceitarEncontrado2;
    private javax.swing.JPanel jButtonAceitarEncontrado3;
    private javax.swing.JPanel jButtonAceitarEncontrado4;
    private javax.swing.JPanel jButtonAceitarPerdido1;
    private javax.swing.JPanel jButtonAceitarPerdido2;
    private javax.swing.JPanel jButtonAceitarPerdido3;
    private javax.swing.JPanel jButtonAceitarPerdido4;
    private javax.swing.JPanel jButtonAtualizarUsuario;
    private javax.swing.JPanel jButtonCadastroUsuario;
    private javax.swing.JPanel jButtonExcluirUsuario;
    private javax.swing.JPanel jButtonNovoEncontrado;
    private javax.swing.JPanel jButtonNovoPerdido;
    private javax.swing.JPanel jButtonRejeitarEncontrado1;
    private javax.swing.JPanel jButtonRejeitarEncontrado22;
    private javax.swing.JPanel jButtonRejeitarEncontrado3;
    private javax.swing.JPanel jButtonRejeitarEncontrado4;
    private javax.swing.JPanel jButtonRejeitarPerdido1;
    private javax.swing.JPanel jButtonRejeitarPerdido2;
    private javax.swing.JPanel jButtonRejeitarPerdido3;
    private javax.swing.JPanel jButtonRejeitarPerdido4;
    private javax.swing.JPanel jButtonVisualizarUsuario;
    private javax.swing.JLabel jLADMNome;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JLabel jLPerdidosQuantidade;
    private javax.swing.JLabel jLQuantidadeEncontrados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAutorEncontrado1;
    private javax.swing.JLabel jLabelAutorEncontrado2;
    private javax.swing.JLabel jLabelAutorEncontrado3;
    private javax.swing.JLabel jLabelAutorEncontrado4;
    private javax.swing.JLabel jLabelAutorPerdido1;
    private javax.swing.JLabel jLabelAutorPerdido2;
    private javax.swing.JLabel jLabelAutorPerdido3;
    private javax.swing.JLabel jLabelAutorPerdido4;
    private javax.swing.JTextPane jLabelDescricaoEncontrado1;
    private javax.swing.JTextPane jLabelDescricaoEncontrado2;
    private javax.swing.JTextPane jLabelDescricaoEncontrado3;
    private javax.swing.JTextPane jLabelDescricaoEncontrado4;
    private javax.swing.JTextPane jLabelDescricaoPerdido1;
    private javax.swing.JTextPane jLabelDescricaoPerdido2;
    private javax.swing.JTextPane jLabelDescricaoPerdido3;
    private javax.swing.JTextPane jLabelDescricaoPerdido4;
    private javax.swing.JLabel jLabelFinal;
    private javax.swing.JLabel jLabelFotoEncontrado1;
    private javax.swing.JLabel jLabelFotoEncontrado2;
    private javax.swing.JLabel jLabelFotoEncontrado3;
    private javax.swing.JLabel jLabelFotoEncontrado4;
    private javax.swing.JLabel jLabelFotoPerdido1;
    private javax.swing.JLabel jLabelFotoPerdido2;
    private javax.swing.JLabel jLabelFotoPerdido3;
    private javax.swing.JLabel jLabelFotoPerdido4;
    private javax.swing.JLabel jLabelLocalEncontrado1;
    private javax.swing.JLabel jLabelLocalEncontrado2;
    private javax.swing.JLabel jLabelLocalEncontrado3;
    private javax.swing.JLabel jLabelLocalEncontrado4;
    private javax.swing.JLabel jLabelLocalPerdido1;
    private javax.swing.JLabel jLabelLocalPerdido2;
    private javax.swing.JLabel jLabelLocalPerdido3;
    private javax.swing.JLabel jLabelLocalPerdido4;
    private javax.swing.JLabel jLabelTituloEncontrado1;
    private javax.swing.JLabel jLabelTituloEncontrado2;
    private javax.swing.JLabel jLabelTituloEncontrado3;
    private javax.swing.JLabel jLabelTituloEncontrado4;
    private javax.swing.JLabel jLabelTituloPerdido1;
    private javax.swing.JLabel jLabelTituloPerdido2;
    private javax.swing.JLabel jLabelTituloPerdido3;
    private javax.swing.JLabel jLabelTituloPerdido4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelEncontrado1;
    private javax.swing.JPanel jPanelEncontrado2;
    private javax.swing.JPanel jPanelEncontrado3;
    private javax.swing.JPanel jPanelEncontrado4;
    private javax.swing.JPanel jPanelEncontrados;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelPerdido1;
    private javax.swing.JPanel jPanelPerdido2;
    private javax.swing.JPanel jPanelPerdido3;
    private javax.swing.JPanel jPanelPerdido4;
    private javax.swing.JPanel jPanelPerdidos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    // End of variables declaration//GEN-END:variables

    private void disableComponents(int i) {
        System.out.println ("Entrou na função de disableComponents com parâmetro "+i);
        switch (i) {
            case 1:
                jLabelFotoEncontrado1.setVisible(false);
                jButtonAceitarEncontrado1.setVisible(false);
                jButtonRejeitarEncontrado1.setVisible(false);
                jLabelTituloEncontrado1.setVisible(false);
                jLabelDescricaoEncontrado1.setText("Nenhum item pendente");
                jLabelDescricaoEncontrado1.setFont(new java.awt.Font("Arial", 2, 17));
                jLabelDescricaoEncontrado1.setForeground(new java.awt.Color(102, 102, 102));
                //lasses.Local = p1.getLocal();
                jLabelLocalEncontrado1.setVisible(false);
                jLabelAutorEncontrado1.setVisible(false);
                jPanelEncontrado2.setVisible(false);
                jPanelEncontrado3.setVisible(false);
                jPanelEncontrado4.setVisible(false);
                break;
            case 2:
                jPanelEncontrado2.setVisible(false);
                jPanelEncontrado3.setVisible(false);
                jPanelEncontrado4.setVisible(false);
                break;
            case 3:
                jPanelEncontrado3.setVisible(false);
                jPanelEncontrado4.setVisible(false);
                break;
            case 4:
                jPanelEncontrado4.setVisible(false);
                break;
            case 5:
                jLabelFotoPerdido1.setVisible(false);
                jButtonAceitarPerdido1.setVisible(false);
                jButtonRejeitarPerdido1.setVisible(false);
                jLabelTituloPerdido1.setVisible(false);
                jLabelDescricaoPerdido1.setText("Nenhum item pendente");
                jLabelDescricaoPerdido1.setFont(new java.awt.Font("Arial", 2, 17)); // NOI18N
                jLabelDescricaoPerdido1.setForeground(new java.awt.Color(102, 102, 102));
                //lasses.Local = p1.getLocal();
                jLabelLocalPerdido1.setVisible(false);
                jLabelAutorPerdido1.setVisible(false);
                jPanelPerdido2.setVisible(false);
                jPanelPerdido3.setVisible(false);
                jPanelPerdido4.setVisible(false);
                break;
            case 6:
                jPanelPerdido2.setVisible(false);
                jPanelPerdido3.setVisible(false);
                jPanelPerdido4.setVisible(false);
                break;
            case 7:
                jPanelPerdido3.setVisible(false);
                jPanelPerdido4.setVisible(false);
                break;
            case 8:
                jPanelPerdido4.setVisible(false);
                break;
        }
    }
}
