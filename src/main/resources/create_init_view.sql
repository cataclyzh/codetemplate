CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `v_org` AS
SELECT
  `o`.`id`      AS `org_id`,
  `o`.`name`    AS `org_name`,
  `o`.`type`    AS `org_type`
FROM `ga_sys`.`sys_org` `o`




CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `v_user` AS
SELECT
  `u`.`id`      AS `user_id`,
  `u`.`name`    AS `user_name`,
  `u`.`work_no` AS `work_no`,
  `u`.`mobile`  AS `mobile`,
  `o`.`id`      AS `org_id`,
  `o`.`name`    AS `org_name`,
  `o`.`type`    AS `org_type`
FROM (`ga_sys`.`sys_user` `u`
   LEFT JOIN `ga_sys`.`sys_org` `o`
     ON ((`u`.`organization_id` = `o`.`id`)))

