import projeto.Usuario.ValidacaoSenhaService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidacaoSenhaServiceTest {

    private final ValidacaoSenhaService service =
            new ValidacaoSenhaService();

    @Test
    void deveAceitarSenhaValida() {
        assertTrue(service.validarSenha("Java@12345"));
    }

    @Test
    void deveRejeitarSenhaComMenosDe10Caracteres() {
        assertFalse(service.validarSenha("Java@123"));
    }

    @Test
    void deveRejeitarSenhaComMaisDe12Caracteres() {
        assertFalse(service.validarSenha("Java@12345678"));
    }

    @Test
    void deveRejeitarSenhaSemNumero() {
        assertFalse(service.validarSenha("Java@Test!"));
    }

    @Test
    void deveRejeitarSenhaSemLetra() {
        assertFalse(service.validarSenha("123456@789"));
    }

    @Test
    void deveRejeitarSenhaSemCaractereEspecial() {
        assertFalse(service.validarSenha("Java123456"));
    }

    @Test
    void deveRejeitarSenhaNula() {
        assertFalse(service.validarSenha(null));
    }

    @Test
    void deveRejeitarSenhaVazia() {
        assertFalse(service.validarSenha(""));
    }

    @Test
    void deveAceitarSenhaComExatamente10Caracteres() {
        assertTrue(service.validarSenha("Abcde@1234"));
    }

    @Test
    void deveAceitarSenhaComExatamente12Caracteres() {
        assertTrue(service.validarSenha("Abcdef@12345"));
    }
}