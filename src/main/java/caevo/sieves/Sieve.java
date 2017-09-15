package caevo.sieves;

import java.util.List;

import caevo.SieveDocument;
import caevo.SieveDocuments;
import caevo.tlink.TLink;

/**
 * Interface for all sieves in the TimeSieve.
 * @author chambers
 */
public interface Sieve {

	/**
	 * Annotate a single document. Generate TLinks between events and timex pairs, based on
	 * the progress given in the list of TLinks already generated by previous sieves.
	 * 
	 * @param doc The pre-processed document information for a set of documents. We assume 
	 *             that it includes all events and timexes, parse trees, and dependencies.
	 * @param currentTLinks The list of TLinks in document 'docname' that were created
	 *        by all previous sieves above this one.
	 * @return A list of new TLinks from document 'docname' (do not include current tlinks).
	 */
	public List<TLink> annotate(SieveDocument doc, List<TLink> currentTLinks);

	/**
	 * This function should perform any training that the sieve requires. The given InfoFile is
	 * intended to include all training data, but the sieve might also use system properties to
	 * access external data. 
	 * 
	 * Some sieves won't be data-driven, and this function might be empty.
	 * 
	 * @param trainingInfo The pre-processed document information for a set of documents.
	 */
	public void train(SieveDocuments infoDocs);
}
