package interfaces;

import entities.Profissional;

public interface IProfissionalRepository {

	void exportarDados(Profissional profissional) throws Exception;
}
