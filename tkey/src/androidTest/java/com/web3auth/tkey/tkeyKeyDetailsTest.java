package com.web3auth.tkey;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.web3auth.tkey.ThresholdKey.Common.PrivateKey;
import com.web3auth.tkey.ThresholdKey.KeyDetails;
import com.web3auth.tkey.ThresholdKey.ServiceProvider;
import com.web3auth.tkey.ThresholdKey.StorageLayer;
import com.web3auth.tkey.ThresholdKey.ThresholdKey;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class tkeyKeyDetailsTest {
    static {
        System.loadLibrary("tkey-native");
    }

    private static KeyDetails details;

    @BeforeClass
    public static void setupTest() {
        try {
            PrivateKey postboxKey = PrivateKey.generate();
            StorageLayer storageLayer = new StorageLayer(false, "https://metadata.tor.us", 2);
            ServiceProvider serviceProvider = new ServiceProvider(false, postboxKey.hex);
            ThresholdKey thresholdKey = new ThresholdKey(null, null, storageLayer, serviceProvider, null, null, false, false);
            PrivateKey key = PrivateKey.generate();
            tkeyKeyDetailsTest.details = thresholdKey.initialize(key.hex, null, false, false);
        } catch (RuntimeError e) {
            fail(e.toString());
        }
    }

    @AfterClass
    public static void cleanTest() {
        System.gc();
    }

    @Test
    public void publicKeyPoint() {
        try {
            details.getPublicKeyPoint();
        } catch (RuntimeError e) {
            fail(e.toString());
        }
    }

    @Test
    public void threshold() {
        try {
            assertNotEquals(details.getThreshold(), 0);
        } catch (RuntimeError e) {
            fail(e.toString());
        }
    }

    @Test
    public void requiredShares() {
        try {
            details.getRequiredShares();
        } catch (RuntimeError e) {
            fail(e.toString());
        }
    }

    @Test
    public void totalShares() {
        try {
            assertNotEquals(details.getTotalShares(), 0);
        } catch (RuntimeError e) {
            fail(e.toString());
        }
    }

    @Test
    public void shareDescriptions() {
        try {
            assertNotEquals(details.getShareDescriptions().length(), 0);
        } catch (RuntimeError e) {
            fail(e.toString());
        }
    }
}
