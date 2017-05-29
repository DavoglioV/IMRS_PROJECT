package metricas.acoplamentoaferente;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.repodriller.domain.Commit;
import org.repodriller.persistence.PersistenceMechanism;
import org.repodriller.scm.CommitVisitor;
import org.repodriller.scm.RepositoryFile;
import org.repodriller.scm.SCMRepository;

import communs.Utils;

public class AcoplamentoAferente implements CommitVisitor {

	public void process(SCMRepository repo, Commit commit,
			PersistenceMechanism writer) {
		ArrayList<String> teste = new ArrayList<String>();
		String[] javaFiles;
		String[] srcFolders;

		try {
			// Faz o checkout do commit selecionado
			repo.getScm().checkout(commit.getHash());
			
			// Obtém lista dos arquivos presentes neste commit
			List<RepositoryFile> files = repo.getScm().files();
			
			srcFolders = (String[])Utils.getAllDirs(repo.getPath());
			javaFiles = (String[])Utils.getVetorJavaFiles(repo.getScm().files());
			
			for (int i=0; i<files.size(); i++) {
				RepositoryFile file = files.get(i);
				String[] partitions = {file.getFile().getAbsolutePath()};
				if (!file.fileNameEndsWith(".java"))
					continue;
				
				File soFile = file.getFile();

				NumeroDeReferencias visitor = new NumeroDeReferencias();
				new JDTRunner().visit(
						visitor, new ByteArrayInputStream(readFile(soFile).getBytes()), srcFolders, partitions);
				
				
				//pegar a String (resultado da lista das referencias) e criar um for
				//buscando 
				Set<String> variables = visitor.getTiposReferenciados();
				
				writer.write(
						commit.getHash(),
						file.getFullName(),
						variables.size()
				);
			}

			writer.write("");
		} finally {
			repo.getScm().reset();
		}
	}


	
	private String readFile(File f) {
		try {
			FileInputStream input = new FileInputStream(f);
			String text = IOUtils.toString(input);
			input.close();
			return text;
		} catch (Exception e) {
			throw new RuntimeException("error reading file " + f.getAbsolutePath(), e);
		}
	}

	public String name() {
		return "JAVA-PARSE";
	}

}
