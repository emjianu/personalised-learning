import {Choice} from "./choice";
import {Lesson} from "../lesson/lesson";

export class Question {
  id: number;
  questionText: string;
  currentChoices: Choice[];
  answer: string;
  lesson: Lesson;
  appliedDifficulty: number;
}
