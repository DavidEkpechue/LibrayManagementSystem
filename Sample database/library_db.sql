-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 06, 2024 at 03:14 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `title` varchar(255) NOT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `publication_date` date DEFAULT NULL,
  `description` text DEFAULT NULL,
  `language` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `title`, `genre`, `author`, `price`, `publication_date`, `description`, `language`) VALUES
(1, 'To Kill a Mockingbird', 'Fiction', 'Harper Lee', 10.99, '1960-07-11', 'A novel about the serious issues of rape and racial inequality.', 'English'),
(2, '1984', 'Dystopian', 'George Orwell', 8.99, '1949-06-08', 'A story about government surveillance and totalitarianism.', 'English'),
(3, 'Moby Dick', 'Adventure', 'Herman Melville', 12.50, '1851-10-18', 'The narrative of Captain Ahab’s obsessive quest to kill the white whale.', 'English'),
(4, 'The Great Gatsby', 'Classic', 'F. Scott Fitzgerald', 10.00, '1925-04-10', 'A story about the American dream and the decadence of the 1920s.', 'English'),
(5, 'Pride and Prejudice', 'Romance', 'Jane Austen', 9.99, '1813-01-28', 'A romantic novel that critiques the British landed gentry.', 'English'),
(6, 'The Catcher in the Rye', 'Fiction', 'J.D. Salinger', 10.99, '1951-07-16', 'A story about teenage angst and alienation.', 'English'),
(7, 'Brave New World', 'Dystopian', 'Aldous Huxley', 11.50, '1932-08-01', 'A novel about a futuristic society based on technological advancement.', 'English'),
(8, 'Fahrenheit 451', 'Dystopian', 'Ray Bradbury', 9.99, '1953-10-19', 'A story about a future where books are banned and \"firemen\" burn them.', 'English'),
(9, 'The Hobbit', 'Fantasy', 'J.R.R. Tolkien', 14.99, '1937-09-21', 'A tale of a hobbit’s adventure with a group of dwarves.', 'English'),
(10, 'War and Peace', 'Historical Fiction', 'Leo Tolstoy', 19.99, '1869-01-01', 'A historical novel that chronicles the French invasion of Russia.', 'English'),
(11, 'test', 'test', 'test', 0.00, '2024-10-06', 'test', 'test'),
(12, 'The Silent Patient', 'Thriller', 'Alex Michaelides', 14.99, '2019-02-05', 'A psychological thriller about a woman who shoots her husband and stops speaking.', 'English'),
(13, 'Where the Crawdads Sing', 'Mystery', 'Delia Owens', 12.99, '2018-08-14', 'A coming-of-age murder mystery set in the marshes of North Carolina.', 'English'),
(14, 'Educated', 'Memoir', 'Tara Westover', 16.99, '2018-02-20', 'A memoir about a woman who grows up in a strict and abusive household in rural Idaho.', 'English'),
(15, 'Anxious People', 'Contemporary Fiction', 'Fredrik Backman', 14.99, '2020-09-08', 'A poignant tale about a bank robbery gone wrong and the strangers taken hostage.', 'English'),
(16, 'The Vanishing Half', 'Historical Fiction', 'Brit Bennett', 16.99, '2020-06-02', 'A multi-generational saga about twin sisters who choose different paths in life.', 'English'),
(17, 'Circe', 'Fantasy', 'Madeline Miller', 15.99, '2018-04-10', 'A modern retelling of the story of Circe, the witch from Greek mythology.', 'English'),
(18, 'The Song of Achilles', 'Historical Fiction', 'Madeline Miller', 13.99, '2011-09-20', 'A retelling of the story of Achilles from the perspective of his companion, Patroclus.', 'English'),
(19, 'The Night Circus', 'Fantasy', 'Erin Morgenstern', 12.99, '2011-09-13', 'A tale of a magical competition between two young illusionists.', 'English'),
(20, 'The 5th Wave', 'Science Fiction', 'Rick Yancey', 11.99, '2013-05-07', 'A post-apocalyptic novel about an alien invasion and a girl trying to survive.', 'English'),
(21, 'The Immortalists', 'Literary Fiction', 'Chloe Benjamin', 15.99, '2018-01-09', 'A novel about four siblings who learn the dates of their deaths and how it shapes their lives.', 'English'),
(22, 'Homegoing', 'Historical Fiction', 'Yaa Gyasi', 14.99, '2016-09-07', 'A multi-generational saga of two half-sisters and their descendants.', 'English'),
(23, 'The Light We Lost', 'Romance', 'Jill Santopolo', 12.99, '2017-05-09', 'A love story about the choices we make and the paths we take.', 'English'),
(24, 'Big Little Lies', 'Drama', 'Liane Moriarty', 12.99, '2014-07-29', 'A tale of murder and deceit among a group of friends.', 'English'),
(25, 'Before We Were Strangers', 'Romance', 'Renée Carlino', 11.99, '2015-08-18', 'A second chance romance between two former college friends.', 'English'),
(26, 'The Girl on the Train', 'Thriller', 'Paula Hawkins', 9.99, '2015-01-13', 'A psychological thriller about a woman who becomes entangled in a missing person investigation.', 'English'),
(27, 'The House in the Cerulean Sea', 'Fantasy', 'TJ Klune', 16.99, '2020-03-17', 'A whimsical story about a man who works for a magical government agency.', 'English'),
(28, 'All the Light We Cannot See', 'Historical Fiction', 'Anthony Doerr', 14.99, '2014-05-06', 'A story set during WWII about a blind French girl and a German boy whose paths collide.', 'English'),
(29, 'The Midnight Library', 'Fantasy', 'Matt Haig', 12.99, '2020-08-13', 'A novel about a library that allows one to explore alternate lives based on different choices.', 'English'),
(30, 'The Henna Artist', 'Historical Fiction', 'Alka Joshi', 15.99, '2020-03-02', 'A story about a woman in post-independence India who escapes her past.', 'English'),
(31, 'Daisy Jones & The Six', 'Historical Fiction', 'Taylor Jenkins Reid', 14.99, '2019-03-05', 'A fictional oral history of a rock band in the 1970s.', 'English'),
(32, 'The Water Dancer', 'Historical Fiction', 'Ta-Nehisi Coates', 16.99, '2019-09-24', 'A magical exploration of the lives of enslaved people in America.', 'English'),
(33, 'Fahrenheit 451', 'Dystopian', 'Ray Bradbury', 12.99, '1953-10-19', 'A story about a future society where books are banned.', 'English'),
(34, 'The Alchemist', 'Adventure', 'Paulo Coelho', 15.99, '1988-04-01', 'A novel about a shepherd’s journey to find treasure.', 'Portuguese'),
(35, 'Jane Eyre', 'Romance', 'Charlotte Brontë', 10.99, '1847-10-16', 'A story about an orphaned girl who becomes a governess.', 'English'),
(36, 'The Chronicles of Narnia', 'Fantasy', 'C.S. Lewis', 9.99, '1950-10-16', 'A series of seven fantasy novels about the land of Narnia.', 'English'),
(37, 'The Kite Runner', 'Drama', 'Khaled Hosseini', 15.99, '2003-05-29', 'A story of friendship and redemption set in Afghanistan.', 'English'),
(38, 'The Road', 'Post-apocalyptic', 'Cormac McCarthy', 12.99, '2006-09-26', 'A bleak tale of survival in a post-apocalyptic world.', 'English'),
(39, 'Harry Potter and the Sorcerer\'s Stone', 'Fantasy', 'J.K. Rowling', 9.99, '1997-06-26', 'The first book in the Harry Potter series.', 'English'),
(40, 'The Fault in Our Stars', 'Young Adult', 'John Green', 12.99, '2012-01-10', 'A story about two teenagers who meet at a cancer support group.', 'English'),
(41, 'The Odyssey', 'Epic', 'Homer', 13.99, '0000-00-00', 'An epic poem about the adventures of Odysseus.', 'Greek'),
(42, 'The Picture of Dorian Gray', 'Philosophical Fiction', 'Oscar Wilde', 9.99, '1890-07-01', 'A story about a young man whose portrait ages while he remains young.', 'English'),
(43, 'test2', 'test2', 'test2', 0.00, '2024-09-30', 'test2', 'test2');

-- --------------------------------------------------------

--
-- Table structure for table `borrowed_books`
--

CREATE TABLE `borrowed_books` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `book_id` bigint(20) UNSIGNED DEFAULT NULL,
  `borrow_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrowed_books`
--

INSERT INTO `borrowed_books` (`id`, `user_id`, `book_id`, `borrow_date`, `return_date`) VALUES
(1, 6, 11, '2024-10-06', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `logged_in` tinyint(1) DEFAULT 0,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `role` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `logged_in`, `created_at`, `role`) VALUES
(1, 'john_doe', 'P@ssw0rd123', 1, '2024-10-06 12:45:02', 1),
(2, 'jane_doe', 'M0bY_4Ever!', 0, '2024-10-06 12:45:02', 1),
(3, 'alice', 'Love2Read!', 0, '2024-10-06 12:45:02', 1),
(4, 'bob_smith', 'B0bSmiTh!2024', 1, '2024-10-06 12:45:02', 1),
(5, 'charlie_brown', 'Ch4rlie$Life', 0, '2024-10-06 12:45:02', 1),
(6, '', '', 0, '2024-10-06 12:46:11', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `borrowed_books`
--
ALTER TABLE `borrowed_books`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `book_id` (`book_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `borrowed_books`
--
ALTER TABLE `borrowed_books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `borrowed_books`
--
ALTER TABLE `borrowed_books`
  ADD CONSTRAINT `borrowed_books_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `borrowed_books_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
