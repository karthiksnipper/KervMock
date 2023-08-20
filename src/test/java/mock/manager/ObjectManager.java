package mock.manager;

import mock.pages.CareerFormPageKerv;
import mock.pages.KervPage;

public class ObjectManager {
	public KervPage KervPageObjInstance;
	public CareerFormPageKerv CareerFormPageKervObjInstance;
	
	public ObjectManager () {}

	public KervPage getKervPageInstance() {
		return(KervPageObjInstance==null)? KervPageObjInstance = new KervPage(): KervPageObjInstance;
	}
	
	public CareerFormPageKerv getCareerFormPageKervObjInstance() {
		return(CareerFormPageKervObjInstance==null)? CareerFormPageKervObjInstance = new CareerFormPageKerv(): CareerFormPageKervObjInstance;
	}
	
	
}
