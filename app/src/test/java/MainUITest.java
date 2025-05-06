import java.awt.Button;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.SwingUtilities;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // <-- biar @BeforeAll/@AfterAll bisa non-static
public class MainUITest {
    private MainUI ui;
    private Robot robot;

    @BeforeAll
    public void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            ui = new MainUI();
            ui.f.pack(); // ngebantu layouting internal
            ui.f.setVisible(true);
            ui.f.setAlwaysOnTop(true); // buat jaga2 window gak ketutupan
            ui.f.toFront();
            ui.f.requestFocus();
        });

        Thread.sleep(1500); // kasih waktu lebih lama untuk render UI
        robot = new Robot();
        robot.setAutoDelay(100);
    }

    @AfterAll
    public void tearDown() throws Exception {
        SwingUtilities.invokeLater(() -> ui.dispose());
    }

    private void clickButton(Button b1) throws Exception {
        Point location = b1.getLocationOnScreen();
        robot.mouseMove(location.x + 5, location.y + 5);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(200);
    }

    // TC1
    @Test
    public void testClearButtonClearsTextField() throws Exception {
        SwingUtilities.invokeAndWait(() -> ui.t1.setText(""));
        clickButton(ui.bclr);
        SwingUtilities.invokeAndWait(() -> assertEquals("", ui.t1.getText()));
    }

    // TC2
    @Test
    public void testEqualButtonPerformsComputation() throws Exception {
        // Set nilai awal
        SwingUtilities.invokeAndWait(() -> ui.t1.setText("")); // pastikan TextField kosong

        // Simulasi tombol yang ditekan
        clickButton(ui.b1); // 1
        clickButton(ui.badd); // +
        clickButton(ui.b2); // 2
        clickButton(ui.beq); // =

        // Tunggu beberapa waktu agar UI bisa update
        Thread.sleep(500); // biar UI sempat refresh

        // Pastikan hasil di TextField benar
        SwingUtilities.invokeAndWait(() -> {
            assertEquals("3.0", ui.t1.getText()); // pastikan hasil yang muncul adalah 3.0
        });
    }

    // TC3
    @Test
    public void testDecimalInputUpdatesTextField() throws Exception {
        SwingUtilities.invokeAndWait(() -> ui.t1.setText("")); // pastikan TextField kosong

        // Simulasi tombol yang ditekan
        clickButton(ui.b3); // 3
        clickButton(ui.bdot); // .
        clickButton(ui.b4); // 4

        // Tunggu beberapa waktu agar UI bisa update
        Thread.sleep(500);

        // Pastikan hasil di TextField benar
        SwingUtilities.invokeAndWait(() -> {
            assertEquals("3.4", ui.t1.getText()); // pastikan angka 3.4 muncul di TextField
        });
    }

    // TC4
    @Test
    public void testNegativeInputOnEmptyField() throws Exception {
        SwingUtilities.invokeAndWait(() -> ui.t1.setText("")); // pastikan TextField kosong

        // Simulasi tombol yang ditekan
        clickButton(ui.bsub); // -

        // Tunggu beberapa waktu agar UI bisa update
        Thread.sleep(500);

        // Pastikan hasil di TextField adalah tanda negatif (-)
        SwingUtilities.invokeAndWait(() -> {
            assertEquals("-", ui.t1.getText()); // pastikan tanda negatif (-) muncul di TextField
        });
    }

    // TC5
    @Test
    public void testSubtractionWithoutPreviousOperator() throws Exception {
        // Set nilai awal
        SwingUtilities.invokeAndWait(() -> ui.t1.setText("")); // pastikan TextField kosong

        // Simulasi tombol yang ditekan
        clickButton(ui.b4); // 4
        clickButton(ui.bsub); // -
        clickButton(ui.b3); // 3
        clickButton(ui.beq); // =

        // Tunggu beberapa waktu agar UI bisa update
        Thread.sleep(500); // biar UI sempat refresh

        // Pastikan hasil di TextField benar
        SwingUtilities.invokeAndWait(() -> {
            assertEquals("1.0", ui.t1.getText()); // pastikan hasil yang muncul adalah 1.0
        });
    }

    // TC6
    @Test
    public void testNegativeSecondOperandAfterAddition() throws Exception {
        // Set nilai awal
        SwingUtilities.invokeAndWait(() -> ui.t1.setText("")); // pastikan TextField kosong

        // Simulasi tombol yang ditekan
        clickButton(ui.b5); // 5
        clickButton(ui.badd); // +
        clickButton(ui.bsub); // - untuk angka negatif
        clickButton(ui.b6); // 6
        clickButton(ui.beq); // =

        // Tunggu beberapa waktu agar UI bisa update
        Thread.sleep(500);

        // Pastikan hasil di TextField benar
        SwingUtilities.invokeAndWait(() -> {
            assertEquals("-1.0", ui.t1.getText()); // pastikan hasilnya adalah -1.0
        });
    }

    // TC7
    @Test
    public void testAddition() throws Exception {
        // Set nilai awal
        SwingUtilities.invokeAndWait(() -> ui.t1.setText("")); // pastikan TextField kosong

        // Simulasi tombol yang ditekan
        clickButton(ui.b5); // 5
        clickButton(ui.badd); // +
        clickButton(ui.b7); // 7
        clickButton(ui.beq); // =

        // Tunggu beberapa waktu agar UI bisa update
        Thread.sleep(500);

        // Pastikan hasil di TextField benar
        SwingUtilities.invokeAndWait(() -> {
            assertEquals("12.0", ui.t1.getText()); // pastikan hasilnya adalah 12.0
        });
    }

    // TC8
    @Test
    public void testMultiplication() throws Exception {
        // Set nilai awal
        SwingUtilities.invokeAndWait(() -> ui.t1.setText("")); // pastikan TextField kosong

        // Simulasi tombol yang ditekan
        clickButton(ui.b8); // 8
        clickButton(ui.bmul); // *
        clickButton(ui.b9); // 9
        clickButton(ui.beq); // =

        // Tunggu beberapa waktu agar UI bisa update
        Thread.sleep(500);

        // Pastikan hasil di TextField benar
        SwingUtilities.invokeAndWait(() -> {
            assertEquals("72.0", ui.t1.getText()); // pastikan hasilnya adalah 72.0
        });
    }

    // TC9
    @Test
    public void testDivision() throws Exception {
        // Set nilai awal
        SwingUtilities.invokeAndWait(() -> ui.t1.setText("")); // pastikan TextField kosong

        // Simulasi tombol yang ditekan
        clickButton(ui.b9); // 9
        clickButton(ui.bdiv); // /
        clickButton(ui.b3); // 3
        clickButton(ui.beq); // =

        // Tunggu beberapa waktu agar UI bisa update
        Thread.sleep(500);

        // Pastikan hasil di TextField benar
        SwingUtilities.invokeAndWait(() -> {
            assertEquals("3.0", ui.t1.getText()); // pastikan hasilnya adalah 3.0
        });
    }

    // TC10
    @Test
    public void testNumberButtonUpdatesTextField() throws Exception {
        // Bersihin dulu biar tidak ada sisa dari test sebelumnya
        clickButton(ui.bclr);
        Thread.sleep(200); // kasih waktu biar UI keburu update

        clickButton(ui.b6); // tekan angka 6

        SwingUtilities.invokeAndWait(() -> {
            assertEquals("6", ui.t1.getText()); // pastikan text field berisi "6.0"
        });
    }

    // @Test
    // void testDivisionByZero() {
    // String input1 = "10";
    // String input2 = "0";
    // String operator = "/";
    // String expected = "Error: Pembagi tidak boleh nol";

    // String actual = ComputationEngine.processCalculation(input1, input2,
    // operator);

    // Assertions.assertEquals(expected, actual);
    // }
}
