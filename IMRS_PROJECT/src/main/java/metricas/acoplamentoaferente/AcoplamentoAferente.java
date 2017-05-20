package metricas.acoplamentoaferente;

import org.repodriller.domain.Commit;
import org.repodriller.persistence.PersistenceMechanism;
import org.repodriller.scm.CommitVisitor;
import org.repodriller.scm.SCMRepository;

public class AcoplamentoAferente implements CommitVisitor {


    public void process(SCMRepository repo, Commit commit, PersistenceMechanism writer) {
		
		writer.write(
			commit.getHash(),
			commit.getCommitter().getName()
		);

	}

	public String name() {
		return "developers";
	}

}
