import java.util.Vector;

public class Cifrario {

    private Vector<Character> alfabeto = new Vector<Character>();
    private int chiave = 0;
    private String testo_in_chiaro = "";
    private String output = "";

    public Cifrario(int chiave, String testo_in_chiaro) {
        this.chiave = chiave;
        this.testo_in_chiaro = testo_in_chiaro;
        setupAlfabeto();
    }

    private void setupAlfabeto() {
        alfabeto.addElement('a');
        alfabeto.addElement('b');
        alfabeto.addElement('c');
        alfabeto.addElement('d');
        alfabeto.addElement('e');
        alfabeto.addElement('f');
        alfabeto.addElement('g');
        alfabeto.addElement('h');
        alfabeto.addElement('i');
        alfabeto.addElement('j');
        alfabeto.addElement('k');
        alfabeto.addElement('l');
        alfabeto.addElement('m');
        alfabeto.addElement('n');
        alfabeto.addElement('o');
        alfabeto.addElement('p');
        alfabeto.addElement('q');
        alfabeto.addElement('r');
        alfabeto.addElement('s');
        alfabeto.addElement('t');
        alfabeto.addElement('u');
        alfabeto.addElement('v');
        alfabeto.addElement('w');
        alfabeto.addElement('x');
        alfabeto.addElement('y');
        alfabeto.addElement('z');
    }

    private int trovato(char tofind) {
        for (int i = 0; i < alfabeto.size(); i++) {
            if (alfabeto.contains(tofind)) {
                return alfabeto.indexOf(tofind);
            }
        }
        return 0;
    }

    public void cifra() {
        String temp_input = testo_in_chiaro.toLowerCase();
        String temp_output = "";
        for (char carattere : temp_input.toCharArray()) {
            int next_index = trovato(carattere) + chiave;
            int temp = 0;
            if (next_index < alfabeto.size()) {
                temp_output += alfabeto.elementAt(next_index);
            } else {
                temp = next_index - alfabeto.size();
                temp_output += alfabeto.elementAt(temp);
            }
        }
        setOutput(temp_output.toUpperCase());
    }

    public void decifra() {
        String temp_input = testo_in_chiaro.toLowerCase();
        String temp_output = "";
        for (char carattere : temp_input.toCharArray()) {
            int next_index = trovato(carattere) - chiave;
            int temp = 0;
            if (next_index >= 0 && next_index < alfabeto.size()) {
                temp_output += alfabeto.elementAt(next_index);
            } else if (next_index < 0) {
                temp = alfabeto.size() + next_index;
                temp_output += alfabeto.elementAt(temp);
            }
        }
        setOutput(temp_output.toUpperCase());
    }

    public String getOutput() {
        return output;
    }

    private void setOutput(String output) {
        this.output = output;
    }
}
