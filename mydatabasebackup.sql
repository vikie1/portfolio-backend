--
-- PostgreSQL database dump
--

-- Dumped from database version 13.8 (Ubuntu 13.8-1.pgdg20.04+1)
-- Dumped by pg_dump version 14.5 (Ubuntu 14.5-2.pgdg20.04+2)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: heroku_ext; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA heroku_ext;


ALTER SCHEMA heroku_ext OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: articles; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.articles (
    name character varying(255) NOT NULL,
    description character varying(255),
    full_article text,
    imgurl character varying(255),
    topic character varying(255),
    id integer NOT NULL
);


ALTER TABLE public.articles OWNER TO saheffhwlbggtb;

--
-- Name: articles_id_seq; Type: SEQUENCE; Schema: public; Owner: saheffhwlbggtb
--

CREATE SEQUENCE public.articles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.articles_id_seq OWNER TO saheffhwlbggtb;

--
-- Name: articles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: saheffhwlbggtb
--

ALTER SEQUENCE public.articles_id_seq OWNED BY public.articles.id;


--
-- Name: authorities; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.authorities (
    username character varying(255) NOT NULL,
    authority character varying(255)
);


ALTER TABLE public.authorities OWNER TO saheffhwlbggtb;

--
-- Name: blogs; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.blogs (
    id bigint NOT NULL,
    description character varying(255),
    imgurl character varying(255),
    name character varying(255) NOT NULL,
    post text,
    post_date date
);


ALTER TABLE public.blogs OWNER TO saheffhwlbggtb;

--
-- Name: blogs_id_seq; Type: SEQUENCE; Schema: public; Owner: saheffhwlbggtb
--

CREATE SEQUENCE public.blogs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.blogs_id_seq OWNER TO saheffhwlbggtb;

--
-- Name: blogs_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: saheffhwlbggtb
--

ALTER SEQUENCE public.blogs_id_seq OWNED BY public.blogs.id;


--
-- Name: blogs_topic; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.blogs_topic (
    blogs_id bigint NOT NULL,
    topic_id bigint NOT NULL
);


ALTER TABLE public.blogs_topic OWNER TO saheffhwlbggtb;

--
-- Name: category; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.category (
    id bigint NOT NULL,
    cat_name character varying(255) NOT NULL,
    nested_category character varying(255)
);


ALTER TABLE public.category OWNER TO saheffhwlbggtb;

--
-- Name: contact; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.contact (
    id bigint NOT NULL,
    email character varying(255),
    message character varying(255),
    name character varying(255),
    subject character varying(255)
);


ALTER TABLE public.contact OWNER TO saheffhwlbggtb;

--
-- Name: course; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.course (
    id bigint NOT NULL,
    chapter double precision NOT NULL,
    content text,
    name character varying(255),
    post_date date,
    course_id_course_id bigint NOT NULL
);


ALTER TABLE public.course OWNER TO saheffhwlbggtb;

--
-- Name: course_id_seq; Type: SEQUENCE; Schema: public; Owner: saheffhwlbggtb
--

CREATE SEQUENCE public.course_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.course_id_seq OWNER TO saheffhwlbggtb;

--
-- Name: course_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: saheffhwlbggtb
--

ALTER SEQUENCE public.course_id_seq OWNED BY public.course.id;


--
-- Name: course_identifiers; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.course_identifiers (
    id bigint NOT NULL,
    description text,
    imgurl character varying(255),
    name character varying(255)
);


ALTER TABLE public.course_identifiers OWNER TO saheffhwlbggtb;

--
-- Name: course_identifiers_id_seq; Type: SEQUENCE; Schema: public; Owner: saheffhwlbggtb
--

CREATE SEQUENCE public.course_identifiers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.course_identifiers_id_seq OWNER TO saheffhwlbggtb;

--
-- Name: course_identifiers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: saheffhwlbggtb
--

ALTER SEQUENCE public.course_identifiers_id_seq OWNED BY public.course_identifiers.id;


--
-- Name: course_identifiers_topic; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.course_identifiers_topic (
    course_identifiers_id bigint NOT NULL,
    topic_id bigint NOT NULL
);


ALTER TABLE public.course_identifiers_topic OWNER TO saheffhwlbggtb;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: saheffhwlbggtb
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO saheffhwlbggtb;

--
-- Name: music_entity; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.music_entity (
    id bigint NOT NULL,
    artist character varying(255),
    music_url character varying(255),
    name character varying(255)
);


ALTER TABLE public.music_entity OWNER TO saheffhwlbggtb;

--
-- Name: music_entity_id_seq; Type: SEQUENCE; Schema: public; Owner: saheffhwlbggtb
--

CREATE SEQUENCE public.music_entity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.music_entity_id_seq OWNER TO saheffhwlbggtb;

--
-- Name: music_entity_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: saheffhwlbggtb
--

ALTER SEQUENCE public.music_entity_id_seq OWNED BY public.music_entity.id;


--
-- Name: music_service_users; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.music_service_users (
    id bigint NOT NULL,
    password character varying(255),
    username character varying(255)
);


ALTER TABLE public.music_service_users OWNER TO saheffhwlbggtb;

--
-- Name: music_service_users_id_seq; Type: SEQUENCE; Schema: public; Owner: saheffhwlbggtb
--

CREATE SEQUENCE public.music_service_users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.music_service_users_id_seq OWNER TO saheffhwlbggtb;

--
-- Name: music_service_users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: saheffhwlbggtb
--

ALTER SEQUENCE public.music_service_users_id_seq OWNED BY public.music_service_users.id;


--
-- Name: projects; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.projects (
    id bigint NOT NULL,
    description character varying(255),
    img_url character varying(255),
    name character varying(255),
    title character varying(255),
    url character varying(255)
);


ALTER TABLE public.projects OWNER TO saheffhwlbggtb;

--
-- Name: road_map; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.road_map (
    id bigint NOT NULL,
    description character varying(255),
    explanation text,
    imgurl character varying(255),
    name character varying(255) NOT NULL,
    post_date date
);


ALTER TABLE public.road_map OWNER TO saheffhwlbggtb;

--
-- Name: road_map_id_seq; Type: SEQUENCE; Schema: public; Owner: saheffhwlbggtb
--

CREATE SEQUENCE public.road_map_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.road_map_id_seq OWNER TO saheffhwlbggtb;

--
-- Name: road_map_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: saheffhwlbggtb
--

ALTER SEQUENCE public.road_map_id_seq OWNED BY public.road_map.id;


--
-- Name: road_map_topics; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.road_map_topics (
    road_maps_id bigint NOT NULL,
    topics_id bigint NOT NULL
);


ALTER TABLE public.road_map_topics OWNER TO saheffhwlbggtb;

--
-- Name: software; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.software (
    id bigint NOT NULL,
    description character varying(255),
    download_url character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    types_id bigint
);


ALTER TABLE public.software OWNER TO saheffhwlbggtb;

--
-- Name: software_of_the_day; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.software_of_the_day (
    id bigint NOT NULL,
    date character varying(255),
    description text,
    download_url character varying(255),
    software character varying(255)
);


ALTER TABLE public.software_of_the_day OWNER TO saheffhwlbggtb;

--
-- Name: to_do_list; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.to_do_list (
    id bigint NOT NULL,
    name character varying(255),
    "time" character varying(255),
    username character varying(255)
);


ALTER TABLE public.to_do_list OWNER TO saheffhwlbggtb;

--
-- Name: topic; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.topic (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.topic OWNER TO saheffhwlbggtb;

--
-- Name: topic_entity; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.topic_entity (
    id bigint NOT NULL,
    topic character varying(255)
);


ALTER TABLE public.topic_entity OWNER TO saheffhwlbggtb;

--
-- Name: topic_id_seq; Type: SEQUENCE; Schema: public; Owner: saheffhwlbggtb
--

CREATE SEQUENCE public.topic_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topic_id_seq OWNER TO saheffhwlbggtb;

--
-- Name: topic_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: saheffhwlbggtb
--

ALTER SEQUENCE public.topic_id_seq OWNED BY public.topic.id;


--
-- Name: type; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.type (
    id bigint NOT NULL,
    type character varying(255) NOT NULL,
    cat_id bigint
);


ALTER TABLE public.type OWNER TO saheffhwlbggtb;

--
-- Name: users; Type: TABLE; Schema: public; Owner: saheffhwlbggtb
--

CREATE TABLE public.users (
    username character varying(255) NOT NULL,
    enabled boolean NOT NULL,
    password character varying(255)
);


ALTER TABLE public.users OWNER TO saheffhwlbggtb;

--
-- Name: articles id; Type: DEFAULT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.articles ALTER COLUMN id SET DEFAULT nextval('public.articles_id_seq'::regclass);


--
-- Name: blogs id; Type: DEFAULT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.blogs ALTER COLUMN id SET DEFAULT nextval('public.blogs_id_seq'::regclass);


--
-- Name: course id; Type: DEFAULT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.course ALTER COLUMN id SET DEFAULT nextval('public.course_id_seq'::regclass);


--
-- Name: course_identifiers id; Type: DEFAULT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.course_identifiers ALTER COLUMN id SET DEFAULT nextval('public.course_identifiers_id_seq'::regclass);


--
-- Name: music_entity id; Type: DEFAULT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.music_entity ALTER COLUMN id SET DEFAULT nextval('public.music_entity_id_seq'::regclass);


--
-- Name: music_service_users id; Type: DEFAULT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.music_service_users ALTER COLUMN id SET DEFAULT nextval('public.music_service_users_id_seq'::regclass);


--
-- Name: road_map id; Type: DEFAULT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.road_map ALTER COLUMN id SET DEFAULT nextval('public.road_map_id_seq'::regclass);


--
-- Name: topic id; Type: DEFAULT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.topic ALTER COLUMN id SET DEFAULT nextval('public.topic_id_seq'::regclass);


--
-- Data for Name: articles; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.articles (name, description, full_article, imgurl, topic, id) FROM stdin;
Boost your react and tailwind development with twin macro. 	Are you a developer working with React js and Tailwind CSS? If yes, are you sure you are fully utilizing the full power of the two?	<h2>What is Twin.macro?</h2>\r\n<strong>This is just an introductory article with no technical information. <br /> We have covered how to use Twin in separate blog(s)</strong>\r\n<p>According to its creator <a href="https://github.com/ben-rogerson/twin.macro" > Ben Rogerson </a> - \r\nTwin blends the magic of Tailwind with the flexibility of CSS-in-JavaScript. I've used it and it's\r\na very elegant utility. Let's dive into it and why you might want to give it a shot. </p>\r\n<h2>Why Twin.macro?</h2>\r\n<h3>1. Very easy to get started and be good at</h3>\r\n<p>Twin.macro is a utility that helps you fully utilise Tailwind CSS in React js styled components and emotion\r\nin addition to more features like reusability and clean coding. Very few concepts are introduced by Twin. So if\r\nyou are conversant with Tailwind, emotion and/or styled components then this is a walk in the park.</p>\r\n<h3>2. Speed of developments</h3>\r\n<p>First with twin you will never have to leave the React component you are creating just to edit styles. <br />\r\nBasically in an ordinary tailwind setup, to add custom styles, you have to either edit a 'styles.css' file or the tailwind.config.js.\r\nWith twin, you just add your 'mix' your custom CSS with your tailwind styles.</p>\r\n<aside>\r\n<img src="https://media.giphy.com/media/wW95fEq09hOI8/giphy.gif" alt="dog dancing gif" />\r\n</aside>\r\n<h3>3. It's in line with React reusable components</h3>\r\n<p>Every react developer wants to create a component that works on the fly when you need it, without having to write a lot of\r\nrepetitive code. <strong>Twin will let you do just that. </strong> </p>\r\n<h3>4. Highly customisable components </h3>\r\n<p>With Twin, you will be able to highly reuse styles and also highly customise the components. <br />\r\nOne way to do this is by creating a component with all the basic styles and then passing styles in the props in case you need a more\r\ncustom look in the particular component that needs it.</p>\r\n<p>You can also store the styles in variables then pass the multiple reusable styles as arrays to the component. <br />\r\nAlso when we talk about styled components then no need to emphasize reusability.</p>\r\n<h2>Caveats when using Twin macro </h2>\r\n<p>Like any great tool, twin macro has its downsides too when used in the wrong way. If you are not careful,\r\nyou might get carried away by its great features making you write bad code (illegible even when properly commented).\r\nAn example is the code for my portfolio website, check it out <a href="https://github.com/vikie1/frontend-portfolio" > in GitHub </a>\r\nOn my defence, I had just learned tailwind and twin macro that's not how I code.</p>\r\n<aside>\r\n<img src="https://media.giphy.com/media/fUYhyT9IjftxrxJXcE/giphy.gif" alt="jelly (from tom and jelly) gif"/>\r\n</aside>	https://res.cloudinary.com/dywei4oex/image/upload/v1630137443/portfolio/grqreqad0fbdypckfu12.jpg	twin macro,tailwind,react	65
\.


--
-- Data for Name: authorities; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.authorities (username, authority) FROM stdin;
victor	ROLE_ADMIN
geminid	ROLE_ADMIN
BurnG	ROLE_BURNG
\.


--
-- Data for Name: blogs; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.blogs (id, description, imgurl, name, post, post_date) FROM stdin;
2	This is a blog detailing my journey towards being a Full Stack web developer. It might help you get to know me and my skill-set better.	https://images.unsplash.com/photo-1498050108023-c5249f4df085__separator__Christopher Gower - Unsplash	How I became a Full Stack Developer and my advice to beginners	<h1 style="text-align:center;">How I became a Full Stack Developer and my advice to beginners</h1>\n<h2>Introduction</h2>\n<p>Knowing where to start in your endeavour to become a Software Engineer is a daunting experience - sometimes discouraging - especially as a self taught developer. My experience was no different. From wondering what <a href="https://en.wikipedia.org/wiki/Programming_language" target="_blank">programming language</a> to study, how long it will take, how it will affect your day job/routine, where to study and a whole plethora of concerns that might be holding you back. In this article I'll tell you all about my experience.</p>\n<h2>Why should you learn coding?</h2>\n<p>There's no denying that software engineering is one of the most in demand career fields currently and also enjoying decent growth rates. Just like any other occupation, it is perfectly okay to get into it due to the prospect of better financial returns that software engineering offers. However, being a very demanding field, passion, determination and loving what you do will fuel you towards success.</p>\n<h2>What motivated me towards coding</h2>\n<p>I come from an Electronics and Computer Engineering backgroud. The initial reason to focus on engineering was the fact that I could build things that have an impact in the society. Software engineering promises this with the minimum starting requirements being a computer, internet connection and a sane mind. Comparing this with other engineering fields which requires very huge resources, I decided to make the switch to software engineering.</p>\n<h2>Where I started</h2>\n<p>A quick google search at the time led me to Python. The language is beginner friendly and is less verbose syntactically. I didn't however move forward with it. The same happened with C-Sharp. I then moved to java. At the time I did not plan on focusing on Web development. I learned core java in the hopes that by the end I would become a desktop (and probably mobile) application developer. It took me around 3-4 months to become to complete the <a href="https://math.hws.edu/javanotes/" target="_blank">resouce I used</a>.</p>\n<p>I spent most of my time at the time automating various activities on my PC. This went on for a few months until I received a request to build a website. Of course as a noob who can code, there was no saying no. Luckily, they weren't on a timeline so I had time to do some research. Again a quick google search (on being a web developer with java)  at the time led to to Java Servlets and JSPs 😫.</p>\n<h2>Going full stack (This part is a bit technical for a beginner)</h2>\n<p>I started by learning HTML and CSS as that was a prerequisite in the <a href="https://www.oreilly.com/library/view/head-first-servlets/9780596516680/" target="_blank">Head First Servlets and JSP</a> before proceeding to servlets and JSPs. I dealt with .war and .xml files fo quite a while. I didn't know about maven for quite a while so I would copy the files to Tomcat's webapps directory (of course I automated the process after a while). Also it's worth noting that I used SQLite for the database (I had learned database systems in school).&nbsp;</p>\n<p>After some time, my beautiful website was done and it was time to deploy😌. This is was a whole different world. First, my war wouldn't cut it - jar file with embedded tomcat was needed, copying files wouldn't work anymore, also deploy via <a href="https://git-scm.com/" target="_blank">git</a> and use <a href="https://maven.apache.org/" target="_blank">maven</a> or <a href="https://gradle.org/" target="_blank">gradle</a> as the build tool. WTH was mav... git wtf😼!! Anyway, I took my time to learn this two technologies and then deployed to heroku using the <a href="https://github.com/heroku/webapp-runner" target="_blank">Webapp Runner</a> to generate a jar. Finally! I could see my web online, but the SQLite database would get deleted by heroku so I made the switch to PostgreSQL.</p>\n<p>This was a good period to me as I would build web applications however, the word Spring Boot kept popping up. After sometime curiosity made me decide to know what it was about. I learned spring boot and coming from the servlets world this was pure magical efficiency. I later decided to study Javascript to give the my webapps more life. Around the same time, I joined the Tech Twitter community and got so much development insights which lead me to build a <a href="https://victormwangi.netlify.app/" target="_blank">portfolio website</a>. I also learned React and tailwind while expounding my knowledge on the Spring Framework and spring boot.</p>\n<h2>Where I am now</h2>\n<p>At the moment, I use <a href="https://spring.io/" target="_blank">Spring</a> for my backend systems and APIs. For the front end part, it really depends on the nature of the application under development. Mostly I use React Js but under some occasions I go with thymeleaf. This website is built using gatsby and you can check its code <a href="https://github.com/vikie1/my-programing-blog.git" target="_blank">on GitHub</a>.</p>\n<p>I plan on using this website to share my knowledge and help those who will be coming after me to get up to speed in tech with ease.</p>\n<p></p>\n<p><strong><em>Footnote: </em></strong>This is my first blog😁.</p>\n	2022-04-27
3	Starting your programming career by learning Git puts you in a better place compared to the developers who learn git later in their career. This blog explains why this is the case.	https://images.unsplash.com/photo-1556075798-4825dfaaf498__separator__Yancy Min - Unsplash	Why Git Should Be the First Thing a Developer Learns and Not Code	<h1>Why Git Should Be the First Thing a Developer Learns and Not Code</h1>\n<p>You seriously should learn version control - git in this case - before you write your first 'Hello World' code. If you've already been learning to code but haven't yet begun studying git, no worries; you can learn it at any time during your programming career. My advice however is to learn it as early as possible, preferably before you start learning programming itself.</p>\n<h2>So what is git?</h2>\n<p><a href="https://git-scm.com/" target="_blank">Git</a> is one of the many <a href="https://en.wikipedia.org/wiki/Version_control" target="_blank">version control systems</a> available. It is distributed in nature and fully open source. Services like GitHub and GitLab will let you host your git repositories. Git is available to a wide range of operating systems, that is, if not all of them. So if you have not yet, then after reading this, I suggest you <a href="https://git-scm.com/downloads" target="_blank">download git</a> and create a GitHub account!</p>\n<h2>Why learn it first?</h2>\n<p>As previously stated, you should learn git before coding, and here's why:</p>\n<p><strong><em>1. Track your progress</em></strong></p>\n<p>If you don't have a clearly defined learning path, programming might be intimidating. It's much worse when you can't seem to recall what you've learned. You can keep track of what you've learnt and when you learned it using git and GitHub. You can view all of the modifications you made to your code while learning and, if possible, strive to improve it as you gain more experience. Because it is common knowledge that as a developer, learning never ends, therefore, being able to track your progress over the years will help you:</p>\n<ul>\n<li>Find out what learning methods work best for you.</li>\n<li>Understand the time of the day that you have been most productive when learning</li>\n<li>Recognize how long it takes you to complete a project after starting a course. This will help you determine how long it takes you to grasp concepts - this is crucial, and you will realize it as your developer career progresses.&nbsp;</li>\n<li>Take pride in your professional advancement. Isn't it cool to see how your <em>'one day I will learn how to code and earn from it🤔' </em>turned to '<ins>day one on my new job!🎉</ins>' ?</li>\n</ul>\n<p><strong><em>2. Showcase you work/progress</em></strong></p>\n<p>Making your learning progress available on GitHub or any other code-hosting platform allows others to know at which point your are in your career. While not all employers will look at your GitHub profile before hiring you, some will. You primarily want to demonstrate to these employers the amount and kind of knowledge you have. It demonstrates your ability to handle a large amount of work, your interests and problem-solving skills (depending on the kind of projects you build while learning) and most significantly it showcases your professionalism, how organised you are and how you will integrate with the team.</p>\n<p><strong><em>3. Learn from your mistakes</em></strong></p>\n<p>With git and GitHub you can revisit the code you wrote in the past. This means you can improve on the code as you learn new concepts. You can get to know your previous bad practices and what kind of good practices you adopted early in your career. Whether you brag to your earlier self by replacing a bruteforce algorithm with the shiny new algorithm that you just learned and observing the differences in performance and readability or replacing a whole block of code with a one-liner😎, is up to you. After all, the best way to learn good practices is by unlearning the bad practices.</p>\n<p><script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-5936211125039704"\n     crossorigin="anonymous"></script></p>\n<p><strong><em>4. Improving your team work</em></strong></p>\n<p>If you are learning coding, chances are that you have friends, an online community, fellow learners at a bootcamp or college classmates that are learning alongside you. Collaborating on a project with them will greatly improve your teamwork skills. You can learn from other developers like yourself and set yourself up in a path of open source contribution.</p>\n<p><strong><em>5. Save time when you will later be coding</em></strong></p>\n<p>Many will agree that learning code isn't some sort of a history lesson where everything you learn will probably just sticks in your brain. Face it, most of the stuff you learn you will end up forgetting. When working on a project as a developer, a lot of time is spent searching for a particular problem online. Most of this are stuff that you learnt. Saving your learning progress on GitHub means you can go back to it as a reference, saving you time that would be spent searching through Stackoverflow, the documentation or wherever else.</p>\n<p><strong><em>6. Eventually you will still have to learn it</em></strong></p>\n<p>No mater what programming language, development stack or area of specialisation you decide to focus on, one this is for sure, you will work with git. Git is the most common version control and is used in all those tech companies you would like to work in. Learning it early in your journey means that later when looking for a job, you can spend your time perfecting your skills or prepping for the interviews.</p>\n<h2>Where to learn git</h2>\n<p>You can learn git from its official documentation, however, if documentations seem daunting to you you can learn from a course that I will be publishing here -&gt; <a href="https://learnfromvictor.netlify.app/courses/git-mastery-for-all-audiences/" target="_blank">https://learnfromvictor.netlify.app/courses/git-mastery-for-all-audiences/</a>&nbsp;</p>\n<p><strong><em>Footnote: </em></strong>If you enjoyed reading this, share it with friends. You can also follow me on social media.</p>\n	2022-05-05
\.


--
-- Data for Name: blogs_topic; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.blogs_topic (blogs_id, topic_id) FROM stdin;
2	4
2	5
2	2
3	6
3	4
\.


--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.category (id, cat_name, nested_category) FROM stdin;
\.


--
-- Data for Name: contact; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.contact (id, email, message, name, subject) FROM stdin;
1	alexokeyo15@gmail.com	Ghfff	Alex Okeyo	Hhjg
68	mickezlewisky1@gmail.com	Good work bro.\nThis is a motive💪	Mickez	100 days coding
71	billyilla49@gmail.com	😂😂your portfolio is amazing I don't even know why you're worried about getting a job	Billy Josiah Illa	You actually have a portfolio 😂😂man I should get my life together
72	mwangivictor20@yahoo.com	Hello just doing some preliminary tests	John	\N
73	mwangivictor20@yahoo.com	This is the correct one	Victor	tuysuio
74	mwangivictor20@yahoo.com	hello, chrome	Victor	\N
75	mwangivictor20@yahoo.com	i guess i messed up	Victor 	\N
103	mwangivictor20@yahoo.com	Hi	john	\N
104	brianteka991@gmail.com	hello vic	peace teka	Consultation
\.


--
-- Data for Name: course; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.course (id, chapter, content, name, post_date, course_id_course_id) FROM stdin;
6	0	<h1>Introduction</h1>\n<p>Git is a Version Control System created by Linus Torvalds the founder of Linux. It is distributed in nature and fully open source. Due to its distributed nature, you can store copies of your git repositories on multiple platforms(if it is a personal project) or with every team member (for team projects). Examples of platforms that will help store your git repositories include GitHub, GitLab and Bitbucket. Each of these platforms will provide different operational benefits but at the core, they help store our git repositories. This way, if anything happens to one of the git repositories, then you can recover an exact copy from any of those remote sources.</p>\n<h2>Why Use Git</h2>\n<ol>\n<li><em>Keeps a comprehensive record of all file changes:</em> Git will stack all the committed changes of your files in one directory. This means anyone who has access to this git repository can see the full history of file changes in the repository. This is very important in maintaining code versions. Also with the help of well written commit messages, you can know what was changed at each point in the commit history.</li>\n<li><em>Branching and merging:</em> When working on code individually or in a team, branching is very important. A developer can create a new branch when working on a new feature or issue. This ensures that only production-ready code is in the main or master branch. When the task in the branch is complete, they can be merged with the main or master branch as production ready code.</li>\n<li><em>Collaboration:</em> Git is a very useful tool for collaboration when developing in using code. Every developer gets a copy of the git repository containing the full history of the project. Each member of the team can work on their own branch and implement features independently of the other members. Members of the team therefore know their task, and what other members are working on. Once they are done and the code is reviewed, it can then be merged to the main branch.</li>\n<li><em>Viewing the file history and Reverting errors:</em> Git allows you to travel back in time (metaphorically) to when your code was working after a commit introduces bugs in your software. This allows you to review and know exactly when things went wrong. Viewing file history on personal projects can also help you as a developer to view your growth over the years and predict some aspects of your software career.</li>\n<li><em>Backup:</em> Before clicking on this course, you might have seen this line <em>'Spilled coffee on your PC and now all your work is gone🙇!? Or did your cat walk on the keyboard and now you don't know what new lines were added?'</em>  This is a clear depiction of the backup merits that git commits can offer. Git can also help you restore an exact copy of your last pushed code if you are using remote repositories or code hosting platforms. All of this can be done with a single command.</li>\n</ol>\n<h2>Integrating git into your development process</h2>\n<p>Git is available to users of all the major operating systems. Most of the Linux distributions come with git preinstalled. To make sure that you have git on your system, open your favourite command line interface and type <span style="color: rgb(226,80,65);"><code>$</code></span><span style="color: rgb(97,189,109);"><code>git --version</code></span>. You should see an output similar to this: <span style="color: rgb(97,189,109);"><code>git version 2.30.2</code></span>.Your version maybe different from mine. If you don't have it installed, follow the guides to install in on your operating system here -&gt; <a href="https://git-scm.com/book/en/v2/Getting-Started-Installing-Git" target="_blank">https://git-scm.com/book/en/v2/Getting-Started-Installing-Git</a> .&nbsp;</p>\n<p>Git functionality is available via a cli, GUI tools and extensions in modern IDEs  and editors. Initialing a git repository is as simple as typing <span style="color: rgb(226,80,65);"><code>$</code></span><span style="color: rgb(97,189,109);"><code>git init</code></span>. This will initialise a git repository in the directory where the command was run by creating a .git directory.</p>\n<p>In the next chapter we will define terms that you are likely to encounter in this course and later when working with git on a scale.</p>\n	Introduction	2022-05-30	4
\.


--
-- Data for Name: course_identifiers; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.course_identifiers (id, description, imgurl, name) FROM stdin;
4	Spilled coffee on your PC and now all your work is gone🙇!? Or did your cat walk on the keyboard and now you don't know what new lines were added? With git that's no issue, you can store all your branches (preferably in a remote repository) and access all your commits instantly in a single pull. Sounds like jargon? this course will put you among the 1% who knows.	https://images.unsplash.com/photo-1627399270231-7d36245355a9__separator__Gabriel Heinzer - Unsplash	Git Mastery for all Audiences
\.


--
-- Data for Name: course_identifiers_topic; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.course_identifiers_topic (course_identifiers_id, topic_id) FROM stdin;
4	6
\.


--
-- Data for Name: music_entity; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.music_entity (id, artist, music_url, name) FROM stdin;
\.


--
-- Data for Name: music_service_users; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.music_service_users (id, password, username) FROM stdin;
\.


--
-- Data for Name: projects; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.projects (id, description, img_url, name, title, url) FROM stdin;
0	An enterprise website for a musical company based in Kenya	https://res.cloudinary.com/victor-portfolio/image/upload/v1623672859/samples/projects/favicon_vimmwr.jpg	full-stack	Official Mesmusiq Entertainment	https://mesmusiqent.herokuapp.com
1	Checkout My github	https://res.cloudinary.com/victor-portfolio/image/upload/v1624280115/samples/projects/GitHub-Mark-120px-plus_g1gtt7.png	github	Github repository	https://github.com/vikie1
3	This is the repository that contains the frontend code of my portfolio	https://res.cloudinary.com/victor-portfolio/image/upload/v1624280242/samples/projects/logo_i5qk6h.png	github	Github repository	https://github.com/vikie1/frontend-portfolio
67	This is the link to the GitHub repository that contains the code that i used for the back end. 	https://res.cloudinary.com/dywei4oex/image/upload/v1630146731/portfolio/pwaa685gzp5tji6u2cjh.png	Portfolio backend code	Spring Boot	https://github.com/vikie1/portfolio-backend
80	This is and educational website where I share my skills on Full Stack web development	https://res.cloudinary.com/dywei4oex/image/upload/v1647251496/betterdevs/oslcrgqn5ljctqrqa28j.png	courses/blog	Learn From Victor	https://learnfromvictor.netlify.app/
\.


--
-- Data for Name: road_map; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.road_map (id, description, explanation, imgurl, name, post_date) FROM stdin;
1	This is meant to test the roadmaps section	<h2>Hello Test for roadmaps</h2>\n<p>Welcome here</p>\n	https://res.cloudinary.com/victor-portfolio/image/upload/v1648022583/buju/te2or0ngaplbhdy1s01i.jpg	Hello Test for roadmaps	2022-03-23
\.


--
-- Data for Name: road_map_topics; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.road_map_topics (road_maps_id, topics_id) FROM stdin;
1	2
1	1
\.


--
-- Data for Name: software; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.software (id, description, download_url, name, types_id) FROM stdin;
\.


--
-- Data for Name: software_of_the_day; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.software_of_the_day (id, date, description, download_url, software) FROM stdin;
\.


--
-- Data for Name: to_do_list; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.to_do_list (id, name, "time", username) FROM stdin;
\.


--
-- Data for Name: topic; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.topic (id, name) FROM stdin;
1	welcome
2	Introduction
3	string
4	beginner
5	full-stack
6	git
8	fdgjhx
9	 
\.


--
-- Data for Name: topic_entity; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.topic_entity (id, topic) FROM stdin;
\.


--
-- Data for Name: type; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.type (id, type, cat_id) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: saheffhwlbggtb
--

COPY public.users (username, enabled, password) FROM stdin;
victor	t	$2a$10$sKcM55mc2YNQ1GjwoTYZxuBi.T7y.5qe28fU0sIygnyCy50UXiAum
geminid	t	$2a$10$3CW5cSwClzAdudvfZVHzPe7GCeKmwtxvc9fvOn.SzUu/gKYpn/Vl2
BurnG	t	$2a$10$cqTMeybvgdgx3N0I0/VdmOxAEqsM56NhGpjF0.krIes8imjBEAJl6
\.


--
-- Name: articles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: saheffhwlbggtb
--

SELECT pg_catalog.setval('public.articles_id_seq', 1, true);


--
-- Name: blogs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: saheffhwlbggtb
--

SELECT pg_catalog.setval('public.blogs_id_seq', 3, true);


--
-- Name: course_id_seq; Type: SEQUENCE SET; Schema: public; Owner: saheffhwlbggtb
--

SELECT pg_catalog.setval('public.course_id_seq', 6, true);


--
-- Name: course_identifiers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: saheffhwlbggtb
--

SELECT pg_catalog.setval('public.course_identifiers_id_seq', 4, true);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: saheffhwlbggtb
--

SELECT pg_catalog.setval('public.hibernate_sequence', 104, true);


--
-- Name: music_entity_id_seq; Type: SEQUENCE SET; Schema: public; Owner: saheffhwlbggtb
--

SELECT pg_catalog.setval('public.music_entity_id_seq', 1, false);


--
-- Name: music_service_users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: saheffhwlbggtb
--

SELECT pg_catalog.setval('public.music_service_users_id_seq', 1, false);


--
-- Name: road_map_id_seq; Type: SEQUENCE SET; Schema: public; Owner: saheffhwlbggtb
--

SELECT pg_catalog.setval('public.road_map_id_seq', 1, true);


--
-- Name: topic_id_seq; Type: SEQUENCE SET; Schema: public; Owner: saheffhwlbggtb
--

SELECT pg_catalog.setval('public.topic_id_seq', 9, true);


--
-- Name: articles articles_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.articles
    ADD CONSTRAINT articles_pkey PRIMARY KEY (id);


--
-- Name: authorities authorities_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.authorities
    ADD CONSTRAINT authorities_pkey PRIMARY KEY (username);


--
-- Name: blogs blogs_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.blogs
    ADD CONSTRAINT blogs_pkey PRIMARY KEY (id);


--
-- Name: blogs_topic blogs_topic_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.blogs_topic
    ADD CONSTRAINT blogs_topic_pkey PRIMARY KEY (blogs_id, topic_id);


--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- Name: contact contact_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contact_pkey PRIMARY KEY (id);


--
-- Name: course_identifiers course_identifiers_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.course_identifiers
    ADD CONSTRAINT course_identifiers_pkey PRIMARY KEY (id);


--
-- Name: course_identifiers_topic course_identifiers_topic_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.course_identifiers_topic
    ADD CONSTRAINT course_identifiers_topic_pkey PRIMARY KEY (course_identifiers_id, topic_id);


--
-- Name: course course_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);


--
-- Name: music_entity music_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.music_entity
    ADD CONSTRAINT music_entity_pkey PRIMARY KEY (id);


--
-- Name: music_service_users music_service_users_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.music_service_users
    ADD CONSTRAINT music_service_users_pkey PRIMARY KEY (id);


--
-- Name: projects projects_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.projects
    ADD CONSTRAINT projects_pkey PRIMARY KEY (id);


--
-- Name: road_map road_map_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.road_map
    ADD CONSTRAINT road_map_pkey PRIMARY KEY (id);


--
-- Name: road_map_topics road_map_topics_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.road_map_topics
    ADD CONSTRAINT road_map_topics_pkey PRIMARY KEY (road_maps_id, topics_id);


--
-- Name: software_of_the_day software_of_the_day_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.software_of_the_day
    ADD CONSTRAINT software_of_the_day_pkey PRIMARY KEY (id);


--
-- Name: software software_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.software
    ADD CONSTRAINT software_pkey PRIMARY KEY (id);


--
-- Name: to_do_list to_do_list_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.to_do_list
    ADD CONSTRAINT to_do_list_pkey PRIMARY KEY (id);


--
-- Name: topic_entity topic_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.topic_entity
    ADD CONSTRAINT topic_entity_pkey PRIMARY KEY (id);


--
-- Name: topic topic_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.topic
    ADD CONSTRAINT topic_pkey PRIMARY KEY (id);


--
-- Name: type type_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.type
    ADD CONSTRAINT type_pkey PRIMARY KEY (id);


--
-- Name: blogs uk_1rwt9y2ka64vyjvnoqd2rel4l; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.blogs
    ADD CONSTRAINT uk_1rwt9y2ka64vyjvnoqd2rel4l UNIQUE (name);


--
-- Name: type uk_5uj1b5sieanedt31v8on15ey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.type
    ADD CONSTRAINT uk_5uj1b5sieanedt31v8on15ey UNIQUE (type);


--
-- Name: software_of_the_day uk_5utrx4b9b1nfr7bwcbad3vvyj; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.software_of_the_day
    ADD CONSTRAINT uk_5utrx4b9b1nfr7bwcbad3vvyj UNIQUE (software);


--
-- Name: category uk_76hjmy2g2c3lmy6eraeo89s2x; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT uk_76hjmy2g2c3lmy6eraeo89s2x UNIQUE (nested_category);


--
-- Name: software uk_g7knwcapgdpij6yx8ggd33rv4; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.software
    ADD CONSTRAINT uk_g7knwcapgdpij6yx8ggd33rv4 UNIQUE (name);


--
-- Name: road_map uk_i82syhg8o3l6gh4hx2r0ikpky; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.road_map
    ADD CONSTRAINT uk_i82syhg8o3l6gh4hx2r0ikpky UNIQUE (name);


--
-- Name: software_of_the_day uk_jba47upxjoyouksix0rqj70f; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.software_of_the_day
    ADD CONSTRAINT uk_jba47upxjoyouksix0rqj70f UNIQUE (date);


--
-- Name: course_identifiers uk_kouiafm5htdisx6pvncgpg08n; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.course_identifiers
    ADD CONSTRAINT uk_kouiafm5htdisx6pvncgpg08n UNIQUE (name);


--
-- Name: topic uk_mbunn9erv8nmf5lk1r2nu0nex; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.topic
    ADD CONSTRAINT uk_mbunn9erv8nmf5lk1r2nu0nex UNIQUE (name);


--
-- Name: category uk_njik5b9b2mrl1s1vx2ve40wt0; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT uk_njik5b9b2mrl1s1vx2ve40wt0 UNIQUE (cat_name);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


--
-- Name: course fk1at34bm49bbv0v9otk6advdll; Type: FK CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT fk1at34bm49bbv0v9otk6advdll FOREIGN KEY (course_id_course_id) REFERENCES public.course_identifiers(id);


--
-- Name: course_identifiers_topic fk2ioil2dyr5u65x9wkjbrblu61; Type: FK CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.course_identifiers_topic
    ADD CONSTRAINT fk2ioil2dyr5u65x9wkjbrblu61 FOREIGN KEY (course_identifiers_id) REFERENCES public.course_identifiers(id);


--
-- Name: software fk5hd074r435uwlibsynewawm0m; Type: FK CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.software
    ADD CONSTRAINT fk5hd074r435uwlibsynewawm0m FOREIGN KEY (types_id) REFERENCES public.type(id);


--
-- Name: blogs_topic fkbufh7ikgeowdsut1pg1yatcvq; Type: FK CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.blogs_topic
    ADD CONSTRAINT fkbufh7ikgeowdsut1pg1yatcvq FOREIGN KEY (blogs_id) REFERENCES public.blogs(id);


--
-- Name: road_map_topics fkd20yy9l8ov4ggk1c5yx6vqexd; Type: FK CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.road_map_topics
    ADD CONSTRAINT fkd20yy9l8ov4ggk1c5yx6vqexd FOREIGN KEY (road_maps_id) REFERENCES public.road_map(id);


--
-- Name: type fkg6xlaelnq6kau2khgktn24qun; Type: FK CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.type
    ADD CONSTRAINT fkg6xlaelnq6kau2khgktn24qun FOREIGN KEY (cat_id) REFERENCES public.category(id);


--
-- Name: blogs_topic fkilnqqu5298olf76vyof9uc3o7; Type: FK CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.blogs_topic
    ADD CONSTRAINT fkilnqqu5298olf76vyof9uc3o7 FOREIGN KEY (topic_id) REFERENCES public.topic(id);


--
-- Name: road_map_topics fknv0q7rd4l2t7dpghy2ycadx0g; Type: FK CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.road_map_topics
    ADD CONSTRAINT fknv0q7rd4l2t7dpghy2ycadx0g FOREIGN KEY (topics_id) REFERENCES public.topic(id);


--
-- Name: course_identifiers_topic fkpeq6ekjono96yohixtg9e0du7; Type: FK CONSTRAINT; Schema: public; Owner: saheffhwlbggtb
--

ALTER TABLE ONLY public.course_identifiers_topic
    ADD CONSTRAINT fkpeq6ekjono96yohixtg9e0du7 FOREIGN KEY (topic_id) REFERENCES public.topic(id);


--
-- Name: SCHEMA heroku_ext; Type: ACL; Schema: -; Owner: postgres
--

GRANT USAGE ON SCHEMA heroku_ext TO saheffhwlbggtb WITH GRANT OPTION;


--
-- Name: LANGUAGE plpgsql; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON LANGUAGE plpgsql TO saheffhwlbggtb;


--
-- PostgreSQL database dump complete
--

