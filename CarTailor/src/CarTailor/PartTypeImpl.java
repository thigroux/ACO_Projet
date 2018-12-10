package CarTailor.src.CarTailor;

import CarTailor.src.CarTailor.Category;
import CarTailor.src.CarTailor.ConflictingRoleException;
import CarTailor.src.CarTailor.Part;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public  class PartTypeImpl implements CarTailor.src.CarTailor.PartType {

    public String name;
	private Category category;
	private Collection<Part> parts;
	private Collection<CarTailor.src.CarTailor.PartType> incompatibleParts;
	private Collection<CarTailor.src.CarTailor.PartType> requirementPart;
	private String description;
	private Class<? extends Part>Classref; 
//constructor
//  
//  public PartTypeImpl(String name,Class<? extends Part>Classref, CategoryImpl categoryImpl ) {
//	  
//	  
//  }
	
	public PartTypeImpl(Category cat, Collection<Part> parts){
		this.category=cat;
	}

	public  PartTypeImpl(String name, String description, Category category, Class<? extends Part> classref) {
		super();
		this.name = name;
		this.category = category;
		this.Classref = classref;	
	}
  
	public Part newInstancePart() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		 Constructor<? extends Part>Constructor;
		 Constructor = Classref.getConstructor();
		 return Constructor.newInstance();	 
	 }
	
	public Iterator<CarTailor.src.CarTailor.PartType> getIncompatibleParts() {
			return incompatibleParts.iterator();
		}

	public void setIncompatibleParts(Collection<CarTailor.src.CarTailor.PartType> incompatibleParts) {
			this.incompatibleParts = incompatibleParts;
		}

	public Iterator<CarTailor.src.CarTailor.PartType> getRequirementPart() {
			return null;
		}

	public void setRequirementPart(Collection<CarTailor.src.CarTailor.PartType> requirementPart) {
			this.requirementPart = requirementPart;
	}
	
	@Override
	public String getdescription() {
		return this.description;
	}

	/*les cas a gerer pour ajouter un imcompatibility a un partType
	 * 1 quand il n'est pas dans les requirements on l'ajoute 
	 * 2 quand il est dja dans la liste des incompatibmes on fait rien 
	 * 3
	 */
	public void addingIncompability(Iterator<CarTailor.src.CarTailor.PartType> CollectiontPartType) {
		//Objects.requireNonNull(refPart);
		
		Objects.requireNonNull(CollectiontPartType);
		List<CarTailor.src.CarTailor.PartType> listimcompa =  new ArrayList();
		List<CarTailor.src.CarTailor.PartType> listRequements = new ArrayList();
		while(this.getRequirement().hasNext()) {
			listRequements.add(this.getRequirement().next());
		}
		
		while(CollectiontPartType.hasNext()) {
			listimcompa.add(CollectiontPartType.next());
		}
		
		for(CarTailor.src.CarTailor.PartType partType : listimcompa) {
			//si t
			    if(listRequements.contains(partType)) {
					try {
						throw new ConflictingRoleException("partType is a requirement");
					} catch (ConflictingRoleException e) {
						e.printStackTrace();
					}
					} 
				if(listimcompa.contains(partType)) {
					try {
						throw new ConflictingRoleException("partType is already existe");
					} catch (ConflictingRoleException e) {
						e.printStackTrace();
					}
				}
				listimcompa.add(this);
			}	
	}

	@Override
	public Iterator<CarTailor.src.CarTailor.PartType> getRequirement() {
		return this.getRequirement();
	}

	@Override
	public Iterator<CarTailor.src.CarTailor.PartType> getIncompPartType() {
		return this.getIncompPartType();
	}

	@Override
	public String getname() {
		return this.name;
	}

	@Override
	public void setdescription(String description) {
		this.description = description;	
	}
}