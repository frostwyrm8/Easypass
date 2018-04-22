/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypass_3_18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author N9864
 */
public class SerializedDataCntl {

    private SerializedDataCollection serializedCollection;
    private static SerializedDataCntl theSerializedDataCntl;
    private final String serializedDataFileName = "PASSData.ser";

    private SerializedDataCntl() {
        getSerializedDataCollection();
    }

    public static SerializedDataCntl getSerializedDataCntl() {
        if (theSerializedDataCntl == null) {
            theSerializedDataCntl = new SerializedDataCntl();
        }
        return theSerializedDataCntl;
    }

    public SerializedDataCollection getSerializedDataCollection() {
        if (serializedCollection == null) {
            readSerializedDataCollection();
            if (serializedCollection == null) {
                serializedCollection = new SerializedDataCollection();
                writeSerializedDataCollection();
                readSerializedDataCollection();

            }
        }
        return serializedCollection;
    }

    public void readSerializedDataCollection() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        String filePath = serializedDataFileName;
        try {
            fis = new FileInputStream(filePath);
            in = new ObjectInputStream(fis);
            serializedCollection = (SerializedDataCollection) in.readObject();
            in.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public void writeSerializedDataCollection() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        String filePath = serializedDataFileName;
        try {
            fos = new FileOutputStream(filePath);
            out = new ObjectOutputStream(fos);
            out.writeObject(serializedCollection);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void createTestSerializedDataCollection() {
        serializedCollection = new SerializedDataCollection();
    }

    final void addPassToListInCollection(Pass PassToAdd) {
        serializedCollection.thePassList.listOfPass.add(PassToAdd);
    }

    final void removePassFromListInCollection(int indexOfPassToRemove) {
        serializedCollection.thePassList.listOfPass.remove(indexOfPassToRemove);
    }

}
