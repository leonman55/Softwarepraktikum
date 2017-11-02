package solutions.exercise1;

//import java.util.ArrayDeque;
import java.util.ArrayList;
//import java.util.Deque;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;
import java.lang.IllegalArgumentException;

import org.sopra.api.Scenario;
import org.sopra.api.exercises.ExerciseSubmission;
import org.sopra.api.exercises.exercise1.ScenarioUtil;
import org.sopra.api.model.EnergyNode;
import org.sopra.api.model.Graph;
import org.sopra.api.model.PlayfieldElement;
import org.sopra.api.model.PlayfieldElement.ElementType;
import org.sopra.api.model.PowerLine;
import org.sopra.api.model.PowerLineType;
import org.sopra.api.model.consumer.Consumer;
import org.sopra.api.model.consumer.ControllableConsumer;
import org.sopra.api.model.producer.ControllableProducer;
import org.sopra.api.model.producer.Producer;

/**
 * 
 * @author Isabelle, Leon, Pascal, Stefan
 */

public class ScenarioUtilImpl implements ExerciseSubmission, ScenarioUtil
{
	
	/**
	 * returns all objects which match type from the given Scenario
	 * @param scenario Loaded scenario from xml file
	 * @param type Type which specifies the searched objects
	 * @return a List with all matching PlayfieldElement objects
	 */
	public List<PlayfieldElement> getPlayfieldElementsByType(Scenario scenario, ElementType type)  throws IllegalArgumentException
	{
		if (scenario == null || type == null) {
		//check for null parameters
			throw new IllegalArgumentException("Parameter is not allowed to be null.");
			//if at least 1 parameter is null, then throw the exception
		}
		List<PlayfieldElement> ret = new ArrayList<>();
		// A Deque is a Double-Ended-Queue. A Queue is a special List, where you just can add something new at the beginning
		for (int x = 0; x <= scenario.getPlayfield().getHorizontalSize()-1; x++) {
		//Iterate over the whole play field in horizontal direction (x-axes)
			for (int y = scenario.getPlayfield().getVerticalSize()-1; y >= 0; y--) {
				//Iterate over the whole play field in vertical direction (y-axes)
				PlayfieldElement element = scenario.getPlayfield().getPlayfieldElement(x, y);
				//Take the play field element by the iterated position (x,y)
				if (element.getElementType() == type) {
				//check if the element type is the same as the searched one
					ret.add(element);
					//if it is the same, then add the current play field element to the result list
				}
			}
		}
		return ret;
		// give the result back
	}
	
	/**
	 * returns a List of all ControllableProducer objects extracted from given graph
	 * @param graph Contains all objects on the playfield
	 * @throws IllegalArgumentException
	 * @return a List with all ControllableProducer objects
	 */
	@Override
	public List<ControllableProducer> getControllableProducers(Graph<EnergyNode, PowerLine> graph) throws IllegalArgumentException
	{
		if(graph == null)
		{
			//check for null parameters
			throw new IllegalArgumentException("Graph darf nicht null sein!");
			//throw exception if null parameter detected
		}
		List<ControllableProducer> back = new ArrayList<>();
		List<EnergyNode> nodes = new ArrayList<>(graph.getNodes());
		
		for (EnergyNode energyNode : nodes)
		{
			if(energyNode instanceof ControllableProducer)
			{
				back.add((ControllableProducer)energyNode);
			}
		}
		
		return back;
		
		/*
		 * Leons alter Code
		 */
//		Set<EnergyNode> nodes = graph.getNodes();
//		EnergyNode[] producers = (EnergyNode[]) nodes.toArray();
//		if(producers.length != 0)
//		{
//			ArrayList<ControllableProducer> back = new ArrayList<>();
//			ControllableProducer prod;
//			for(int i = 0; i < producers.length; i++)
//			{
//				if(producers[i] instanceof ControllableProducer)
//				{
//					prod = (ControllableProducer) producers[i];
//					back.add(prod); 
//				}
//			}
//			return back;
//		}
//		else
//		{
//			return new ArrayList<ControllableProducer>();
//		}
	}

	/**
	 * returns a List of all ControllableConsumer objects extracted from given graph
	 * @param graph Contains all objects on the playfield
	 * @throws IllegalArgumentException
	 * @return a List with all ControllableConsumer objects
	 */
	@Override
	public List<ControllableConsumer> getControllableConsumers(Graph<EnergyNode, PowerLine> graph) throws IllegalArgumentException
	{
	    // TODO Auto-generated method stub
		if(graph == null)
		{
			throw new IllegalArgumentException("Graph darf nicht null sein!");
		}
		List<ControllableConsumer> back = new ArrayList<>();
		List<EnergyNode> nodes = new ArrayList<>(graph.getNodes());
		
		for (EnergyNode energyNode : nodes) {
			if(energyNode instanceof ControllableConsumer)
			{
				back.add((ControllableConsumer)energyNode);
			}
		}
		
		return back;
		
		/*
		 * Leons alter Code
		 */
//		Set<EnergyNode> nodes = graph.getNodes();
//		EnergyNode[] consumers = (EnergyNode[]) nodes.toArray();
//		if(consumers.length != 0)
//		{
//			ArrayList<ControllableConsumer> back = new ArrayList<>();
//			ControllableConsumer con;
//			for(int i = 0; i < consumers.length; i++)
//			{
//				if(consumers[i] instanceof ControllableConsumer)
//				{
//					con = (ControllableConsumer) consumers[i];
//					back.add(con); 
//				}
//			}
//			return back;
//		}
//		else
//		{
//			return new ArrayList<ControllableConsumer>();
//		}
	}

	/**
	 * returns a List of all Producer objects extracted from given graph
	 * @param graph Contains all objects on the playfield
	 * @throws IllegalArgumentException
	 * @return a List with all Producer objects
	 */
	@Override
	public List<Producer> getProducers(Graph<EnergyNode, PowerLine> graph) throws IllegalArgumentException
	{
	    // TODO Auto-generated method stub
		if(graph == null)
		{
			throw new IllegalArgumentException("Graph darf nicht null sein!");
		}
		List<Producer> back = new ArrayList<>();
		List<EnergyNode> nodes = new ArrayList<>(graph.getNodes());
		
		for (EnergyNode energyNode : nodes) {
			if(energyNode instanceof Producer)
			{
				back.add((Producer)energyNode);
			}
		}
		
		return back;
		
		/*
		 * Leons alter Code
		 */
//		Set<EnergyNode> nodes = graph.getNodes();
//		EnergyNode[] producers = (EnergyNode[]) nodes.toArray();
//		if(producers.length != 0)
//		{
//			ArrayList<Producer> back = new ArrayList<>();
//			Producer prod;
//			for(int i = 0; i < producers.length; i++)
//			{
//				if(producers[i] instanceof Producer)
//				{
//					prod = (Producer) producers[i];
//					back.add(prod); 
//				}
//			}
//			return back;
//		}
//		else
//		{
//			return new ArrayList<Producer>();
//		}
	}
	
	/**
	 * returns a List of all Consumer objects extracted from given graph
	 * @param graph Contains all objects on the playfield
	 * @throws IllegalArgumentException
	 * @return a List with all Consumer objects
	 */
	@Override
	public List<Consumer> getConsumers(Graph<EnergyNode, PowerLine> graph) throws IllegalArgumentException
	{
	    // TODO Auto-generated method stub
		if(graph == null)
		{
			throw new IllegalArgumentException("Graph darf nicht null sein!");
		}
		
		List<Consumer> back = new ArrayList<>();
		List<EnergyNode> nodes = new ArrayList<>(graph.getNodes());
		
		for (EnergyNode energyNode : nodes) {
			if(energyNode instanceof Consumer)
			{
				back.add((Consumer)energyNode);
			}
		}
		
		return back;
		
		/*
		 * Leons alter Code
		 */
//		Set<EnergyNode> nodes = graph.getNodes();
//		EnergyNode[] consumers = (EnergyNode[]) nodes.toArray();
//		if(consumers.length != 0)
//		{
//			ArrayList<Consumer> back = new ArrayList<>();
//			Consumer con;
//			for(int i = 0; i < consumers.length; i++)
//			{
//				if(consumers[i] instanceof Consumer)
//				{
//					con = (Consumer) consumers[i];
//					back.add(con); 
//				}
//			}
//			return back;
//		}
//		else
//		{
//			return new ArrayList<Consumer>();
//		}
	}

	/**
	 * returns the Team identifier in format GxxTyy
	 * @return a String in given format
	 */
	@Override
	public String getTeamIdentifier() {
	    // TODO Auto-generated method stub
	    return "G05T04";
	}
	
	/**
	 * returns all PowerLine objects from the given Scenario which match type
	 * @param scenario Loaded scenario from xml file
	 * @param type Type which specifies the searched objects
	 * @return a List with all matching PlayfieldElement objects
	 */
	@Override
	public List<PowerLine> getPowerLinesByType(Graph<EnergyNode, PowerLine> graph, PowerLineType type) throws IllegalArgumentException
	{
		// TODO Auto-generated method stub
		if(graph == null || type == null)
		{
			throw new IllegalArgumentException("graph und type darf nicht null sein!");
		}
		ArrayList<PowerLine> lines = (ArrayList<PowerLine>) graph.getEdges();
		ArrayList<PowerLine> back = new ArrayList<PowerLine>();
		
		for (PowerLine powerLine : lines)
		{
			if(powerLine.getType() == type)
			{
				back.add(powerLine);
			}
		}
		
		return back;
		
//		PowerLine[] lines = (PowerLine[]) edges.toArray();
//		if(lines.length != 0)
//		{
//			List<PowerLine> back = new ArrayList<>();
//			for(int i = 0; i < lines.length; i++)
//			{
//				if(lines[i].getType().equals(type))
//				{
//					back.add(lines[i]);
//				}
//			}
//			return back;
//		}
//		else
//		{
//			return new ArrayList<PowerLine>();
//		}
	}
}
