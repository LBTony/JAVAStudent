package Project.domain;

public class Teacher {
	private int id;
	private String name;
	private String teach;
	
	public Teacher() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeach() {
		return teach;
	}

	public void setTeach(String teach) {
		this.teach = teach;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", teach=" + teach + "]";
	}
	
	
}
