package main;

import processing.core.PApplet;
import toxi.geom.Vec3D;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class VolumeDrawerGUI extends JDialog {

    private VolumeDrawer drawer;

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSlider xSlider;
    private JSlider ySlider;
    private JSlider zSlider;
    private JSpinner xSpinner;
    private JSpinner ySpinner;
    private JSpinner zSpinner;


    public VolumeDrawerGUI(  PApplet drawer ) {

        this.drawer = ( VolumeDrawer ) drawer;


        setContentPane( contentPane );
        setModal( false );
        getRootPane().setDefaultButton( buttonOK );

        connectSlidersWithSpinBoxes();

        buttonOK.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                onOK();
            }
        } );

        buttonCancel.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                onCancel();
            }
        } );


        // call onCancel() when cross is clicked
        setDefaultCloseOperation( DO_NOTHING_ON_CLOSE );
        addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent e ) {
                onCancel();
            }
        } );

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT );
    }

    private void connectSlidersWithSpinBoxes() {
        xSlider.addChangeListener( new ChangeListener() {
            @Override
            public void stateChanged( ChangeEvent e ) {
                JSlider source = ( JSlider ) e.getSource();
                int value = source.getValue();
                xSpinner.setValue( value );
                int xScale = ( Integer ) ( xSpinner.getValue() );
                int yScale = ( Integer ) ( ySpinner.getValue() );
                int zScale = ( Integer ) ( zSpinner.getValue() );
                drawer.scale( drawer.getOriginalMesh(), Vec3D.Axis.Z, xScale, yScale, zScale );
            }
        } );

        ySlider.addChangeListener( new ChangeListener() {
            @Override
            public void stateChanged( ChangeEvent e ) {
                JSlider source = ( JSlider ) e.getSource();
                int value = source.getValue();
                ySpinner.setValue( value );
                int xScale = ( Integer ) ( xSpinner.getValue() );
                int yScale = ( Integer ) ( ySpinner.getValue() );
                int zScale = ( Integer ) ( zSpinner.getValue() );
                drawer.scale( drawer.getOriginalMesh(), Vec3D.Axis.Z, xScale, yScale, zScale );
            }
        } );

        zSlider.addChangeListener( new ChangeListener() {
            @Override
            public void stateChanged( ChangeEvent e ) {
                JSlider source = ( JSlider ) e.getSource();
                int value = source.getValue();
                zSpinner.setValue( value );
                int xScale = ( Integer ) ( xSpinner.getValue() );
                int yScale = ( Integer ) ( ySpinner.getValue() );
                int zScale = ( Integer ) ( zSpinner.getValue() );
                drawer.scale( drawer.getOriginalMesh(), Vec3D.Axis.Z, xScale, yScale, zScale );
            }
        } );
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    private void createUIComponents() {

        xSpinner.setValue( 10 );
        ySpinner.setValue( 10 );
        zSpinner.setValue( 10 );

    }

}
