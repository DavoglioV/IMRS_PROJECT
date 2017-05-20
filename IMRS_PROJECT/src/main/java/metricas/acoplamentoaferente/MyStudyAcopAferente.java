package metricas.acoplamentoaferente;

import metricas.acoplamentoaferente.AcoplamentoAferente;

import org.repodriller.RepoDriller;
import org.repodriller.RepositoryMining;
import org.repodriller.Study;
import org.repodriller.filter.range.Commits;
import org.repodriller.persistence.csv.CSVFile;
import org.repodriller.scm.GitRepository;

public class MyStudyAcopAferente implements Study {
	public static void main(String[] args) {
		new RepoDriller().start(new MyStudyAcopAferente());
	}

	public void execute() {
		new RepositoryMining()
				.in(GitRepository
						.singleProject("C:/Users/vanesilv/git/change-metrics"))
				.through(Commits.all())
				.process(new AcoplamentoAferente(),
						new CSVFile("C:/Users/vanesilv/git/IMRS_PROJECT/IMRS_PROJECT/src/files/file.csv")).mine();
	}
}
// path projeto teste: "C:/Users/vanesilv/git/change-metrics"
// path arquivo teste: "C:/Users/vanesilv/git/IMRS_PROJECT/IMRS_PROJECT/src/files/file.csv"
