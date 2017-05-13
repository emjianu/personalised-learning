import {Choice} from "./choice";
import {Lesson} from "../lesson/lesson";

export class Question {
  id: number;
  questionText: string;
  currentChoices: Choice[];
  answer: string;
  lesson: Lesson;
  appliedDifficulty: number;


  //only for display - apparently to make things clear

  answeredBefore: boolean;
  latestStatus: boolean;
  noOfPreviousAnswers: number;
  noOfPreviousCorrectAnswers: number;
  noOfPreviousWrongAnswers: number;
  currentAbility: number;
  lastPrevAppDiff: number;

}
