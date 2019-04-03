package learning.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topicList = new ArrayList<Topic>(
			Arrays.asList(new Topic("1", "Spring Boot", "P1"), new Topic("2", "Microservice", "P2")));

	public List<Topic> getAllTopics() {
		return topicList;
	}

	public Topic getTopicById(String id) {
		return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();

	}

	public void addTopic(Topic topic) {
		topicList.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topicList.size(); i++) {
			Topic t = topicList.get(i);
			if (t.getId().equals(id)) {
				topicList.set(i, topic);
				return;
			}

		}
	}

	public void deleteTopic(String id) {
		topicList.removeIf(t -> t.getId().equals(id));
	}
}
